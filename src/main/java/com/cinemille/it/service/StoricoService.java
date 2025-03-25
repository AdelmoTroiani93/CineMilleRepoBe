package com.cinemille.it.service;

import com.cinemille.it.domain.Proiezione;
import com.cinemille.it.domain.Storico;
import com.cinemille.it.repository.ProiezioneRepository;
import com.cinemille.it.repository.StoricoRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.cinemille.it.domain.Storico}.
 */
@Service
@Transactional
public class StoricoService {

    private final Logger log = LoggerFactory.getLogger(StoricoService.class);

    private final StoricoRepository storicoRepository;
    private final ProiezioneRepository proiezioneRepository;
    
    public StoricoService(StoricoRepository storicoRepository,ProiezioneRepository proiezioneRepository) {
        this.storicoRepository = storicoRepository;
        this.proiezioneRepository=proiezioneRepository;
    }
    @Transactional(readOnly = true)
    public Page<Storico> findAll(Pageable pageable, LocalDate dataInizio, LocalDate dataFine) {
        log.debug("Request to get all Storico with filters: dataInizio={}, dataFine={}", dataInizio, dataFine);

        if (dataInizio != null && dataFine != null) {
            return storicoRepository.findByDataInizioBetween(dataInizio, dataFine, pageable);
        } else if (dataInizio != null) {
            return storicoRepository.findByDataInizioAfter(dataInizio, pageable);
        } else if (dataFine != null) {
            return storicoRepository.findByDataInizioBefore(dataFine, pageable);
        } else {
            return storicoRepository.findAll(pageable);
        }
    }

   
  
    
    @Transactional
    @Scheduled(cron = "0 0 2 * * ?") // Esegue ogni giorno alle 02:00 di notte
    public void spostaProiezioniScadute() {
        LocalDate oggi = LocalDate.now();
        
        // Prendi le proiezioni scadute
        List<Proiezione> proiezioniScadute = proiezioneRepository.findByDataFineBefore(oggi);

        if (!proiezioniScadute.isEmpty()) {
            // Converti e salva nello storico
            List<Storico> storicoList = proiezioniScadute.stream().map(p -> 
                new Storico(p.getId(),p.getDataProiezione(),p.getDataFine(),p.getFilm(),p.getSala())
            ).toList();
            storicoRepository.saveAll(storicoList);

            // Elimina dal database principale
            proiezioneRepository.deleteAll(proiezioniScadute);

            System.out.println("✅ Spostate " + proiezioniScadute.size() + " proiezioni nello storico.");
        } else {
            System.out.println("⚠️ Nessuna proiezione scaduta trovata.");
        }
    }
}

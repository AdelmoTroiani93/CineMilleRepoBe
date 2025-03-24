package com.cinemille.it.service;

import com.cinemille.it.domain.Proiezione;
import com.cinemille.it.repository.ProiezioneRepository;

import java.time.LocalDate;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.cinemille.it.domain.Proiezione}.
 */
@Service
@Transactional
public class ProiezioneService {

    private final Logger log = LoggerFactory.getLogger(ProiezioneService.class);

    private final ProiezioneRepository proiezioneRepository;

    public ProiezioneService(ProiezioneRepository proiezioneRepository) {
        this.proiezioneRepository = proiezioneRepository;
    }

    /**
     * Save a proiezione.
     *
     * @param proiezione the entity to save.
     * @return the persisted entity.
     */
    public Proiezione save(Proiezione proiezione) {
        log.debug("Request to save Proiezione : {}", proiezione);
        return proiezioneRepository.save(proiezione);
    }

    /**
     * Update a proiezione.
     *
     * @param proiezione the entity to save.
     * @return the persisted entity.
     */
    public Proiezione update(Proiezione proiezione) {
        log.debug("Request to update Proiezione : {}", proiezione);
        return proiezioneRepository.save(proiezione);
    }

    /**
     * Partially update a proiezione.
     *
     * @param proiezione the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Proiezione> partialUpdate(Proiezione proiezione) {
        log.debug("Request to partially update Proiezione : {}", proiezione);

        return proiezioneRepository
            .findById(proiezione.getId())
            .map(existingProiezione -> {
                if (proiezione.getDataProiezione() != null) {
                    existingProiezione.setDataProiezione(proiezione.getDataProiezione());
                }
                if (proiezione.getDataFine() != null) {
                    existingProiezione.setDataFine(proiezione.getDataFine());
                }

                return existingProiezione;
            })
            .map(proiezioneRepository::save);
    }

    /**
     * Get all the proieziones.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Proiezione> findAll(Pageable pageable, LocalDate dataProiezione, LocalDate dataFine) {
        log.debug("Request to get all Proieziones with filters: dataInizio={}, dataFine={}", dataProiezione, dataFine);

        if (dataProiezione != null && dataFine != null) {
            return proiezioneRepository.findByDataProiezioneBetween(dataProiezione, dataFine, pageable);
        } else if (dataProiezione != null) {
            return proiezioneRepository.findByDataProiezioneAfter(dataProiezione, pageable);
        } else if (dataFine != null) {
            return proiezioneRepository.findByDataProiezioneBefore(dataFine, pageable);
        } else {
            return proiezioneRepository.findAll(pageable);
        }
    }

    /**
     * Get one proiezione by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Proiezione> findOne(Long id) {
        log.debug("Request to get Proiezione : {}", id);
        return proiezioneRepository.findById(id);
    }

    /**
     * Delete the proiezione by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Proiezione : {}", id);
        proiezioneRepository.deleteById(id);
    }
}

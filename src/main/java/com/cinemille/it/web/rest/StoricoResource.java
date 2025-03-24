package com.cinemille.it.web.rest;

import com.cinemille.it.domain.Proiezione;
import com.cinemille.it.domain.Storico;
import com.cinemille.it.repository.StoricoRepository;
import com.cinemille.it.service.StoricoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


/**
 * REST controller for managing {@link com.cinemille.it.domain.Storico}.
 */
@RestController
@RequestMapping("/api/storicos")
public class StoricoResource {

    private final Logger log = LoggerFactory.getLogger(StoricoResource.class);

    private static final String ENTITY_NAME = "storico";


    private final StoricoService storicoService;

    private final StoricoRepository storicoRepository;

    public StoricoResource(StoricoService storicoService, StoricoRepository storicoRepository) {
        this.storicoService = storicoService;
        this.storicoRepository = storicoRepository;
    }

    @GetMapping("")
    public ResponseEntity<Page<Storico>> getAllProieziones(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInizio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFine,
            Pageable pageable) {
        log.debug("REST request to get a page of Proieziones");

        try {
            // Chiamata al servizio per ottenere i dati
            Page<Storico> page = storicoService.findAll(pageable, dataInizio, dataFine);

            // Se la pagina è vuota, puoi restituire una risposta vuota
            if (page.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(page); // 204 No Content
            }

            // Se i dati vengono trovati, restituisci una risposta OK (200)
            return ResponseEntity.ok(page);
        } catch (Exception e) {
            // Gestisci gli errori generali e restituisci una risposta con un errore
            log.error("Errore durante il recupero dei dati: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);  // Puoi anche inviare un messaggio di errore specifico nel corpo
        }
    }
}

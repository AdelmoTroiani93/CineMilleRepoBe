package com.cinemille.it.web.rest;

import com.cinemille.it.domain.Proiezione;
import com.cinemille.it.repository.ProiezioneRepository;
import com.cinemille.it.service.ProiezioneService;
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
 * REST controller for managing {@link com.cinemille.it.domain.Proiezione}.
 */
@RestController
@RequestMapping("/api/proieziones")
public class ProiezioneResource {

    private final Logger log = LoggerFactory.getLogger(ProiezioneResource.class);

    private static final String ENTITY_NAME = "proiezione";



    private final ProiezioneService proiezioneService;

    private final ProiezioneRepository proiezioneRepository;

    public ProiezioneResource(ProiezioneService proiezioneService, ProiezioneRepository proiezioneRepository) {
        this.proiezioneService = proiezioneService;
        this.proiezioneRepository = proiezioneRepository;
    }

    /**
     * {@code GET  /proieziones} : get all the proieziones.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of proieziones in body.
     */
    @GetMapping("")
    public ResponseEntity<?> getAllProieziones(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataProiezione,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFine,
            Pageable pageable) {
        log.debug("REST request to get a page of Proiezioni");

        try {
            // Recupera la pagina di Proiezioni dal servizio
            Page<Proiezione> page = proiezioneService.findAll(pageable, dataProiezione, dataFine);

            // Se la pagina è vuota, restituisci un codice 204 (No Content)
            if (page.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("Nessuna proiezione trovata per i criteri specificati.");
            }

            // Se la pagina contiene dati, restituisci la risposta con il codice 200 OK
            return ResponseEntity.ok(page);
        } catch (Exception e) {
            // Gestisci l'errore generico e restituisci un codice 500 (Internal Server Error)
            log.error("Errore durante il recupero dei dati delle proiezioni: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Errore interno durante il recupero dei dati delle proiezioni: " + e.getMessage());
        }
    }

  
}

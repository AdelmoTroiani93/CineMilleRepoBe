package com.cinemille.it.service;

import com.cinemille.it.domain.Cinema;
import com.cinemille.it.repository.CinemaRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.cinemille.it.domain.Cinema}.
 */
@Service
@Transactional
public class CinemaService {

    private final Logger log = LoggerFactory.getLogger(CinemaService.class);

    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    /**
     * Save a cinema.
     *
     * @param cinema the entity to save.
     * @return the persisted entity.
     */
    public Cinema save(Cinema cinema) {
        log.debug("Request to save Cinema : {}", cinema);
        return cinemaRepository.save(cinema);
    }

    /**
     * Update a cinema.
     *
     * @param cinema the entity to save.
     * @return the persisted entity.
     */
    public Cinema update(Cinema cinema) {
        log.debug("Request to update Cinema : {}", cinema);
        return cinemaRepository.save(cinema);
    }

    /**
     * Partially update a cinema.
     *
     * @param cinema the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Cinema> partialUpdate(Cinema cinema) {
        log.debug("Request to partially update Cinema : {}", cinema);

        return cinemaRepository
            .findById(cinema.getId())
            .map(existingCinema -> {
                if (cinema.getNome() != null) {
                    existingCinema.setNome(cinema.getNome());
                }
                if (cinema.getIndirizzo() != null) {
                    existingCinema.setIndirizzo(cinema.getIndirizzo());
                }

                return existingCinema;
            })
            .map(cinemaRepository::save);
    }

    /**
     * Get all the cinemas.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Cinema> findAll() {
        log.debug("Request to get all Cinemas");
        return cinemaRepository.findAll();
    }

    /**
     * Get one cinema by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Cinema> findOne(Long id) {
        log.debug("Request to get Cinema : {}", id);
        return cinemaRepository.findById(id);
    }

    /**
     * Delete the cinema by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cinema : {}", id);
        cinemaRepository.deleteById(id);
    }
}

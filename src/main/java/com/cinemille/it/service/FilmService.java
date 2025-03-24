package com.cinemille.it.service;

import com.cinemille.it.domain.Film;
import com.cinemille.it.repository.FilmRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.cinemille.it.domain.Film}.
 */
@Service
@Transactional
public class FilmService {

    private final Logger log = LoggerFactory.getLogger(FilmService.class);

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    /**
     * Save a film.
     *
     * @param film the entity to save.
     * @return the persisted entity.
     */
    public Film save(Film film) {
        log.debug("Request to save Film : {}", film);
        return filmRepository.save(film);
    }

    /**
     * Update a film.
     *
     * @param film the entity to save.
     * @return the persisted entity.
     */
    public Film update(Film film) {
        log.debug("Request to update Film : {}", film);
        return filmRepository.save(film);
    }

    /**
     * Partially update a film.
     *
     * @param film the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Film> partialUpdate(Film film) {
        log.debug("Request to partially update Film : {}", film);

        return filmRepository
            .findById(film.getId())
            .map(existingFilm -> {
                if (film.getTitolo() != null) {
                    existingFilm.setTitolo(film.getTitolo());
                }
                if (film.getGenere() != null) {
                    existingFilm.setGenere(film.getGenere());
                }
                if (film.getDataUscita() != null) {
                    existingFilm.setDataUscita(film.getDataUscita());
                }
                if (film.getDurata() != null) {
                    existingFilm.setDurata(film.getDurata());
                }

                return existingFilm;
            })
            .map(filmRepository::save);
    }

    /**
     * Get all the films.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Film> findAll() {
        log.debug("Request to get all Films");
        return filmRepository.findAll();
    }

    /**
     * Get one film by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Film> findOne(Long id) {
        log.debug("Request to get Film : {}", id);
        return filmRepository.findById(id);
    }

    /**
     * Delete the film by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Film : {}", id);
        filmRepository.deleteById(id);
    }
}

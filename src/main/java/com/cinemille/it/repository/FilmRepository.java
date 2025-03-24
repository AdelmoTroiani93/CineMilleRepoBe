package com.cinemille.it.repository;

import com.cinemille.it.domain.Film;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Film entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {}

package com.cinemille.it.repository;

import com.cinemille.it.domain.Cinema;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Cinema entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {}

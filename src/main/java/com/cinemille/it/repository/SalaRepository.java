package com.cinemille.it.repository;

import com.cinemille.it.domain.Sala;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Sala entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {}

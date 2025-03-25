package com.cinemille.it.repository;

import com.cinemille.it.domain.Proiezione;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Proiezione entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProiezioneRepository extends JpaRepository<Proiezione, Long> {
	  Page<Proiezione> findByDataProiezioneBetween(LocalDate dataInizio, LocalDate dataFine, Pageable pageable);

	    Page<Proiezione> findByDataProiezioneAfter(LocalDate dataInizio, Pageable pageable);

	    Page<Proiezione> findByDataProiezioneBefore(LocalDate dataFine, Pageable pageable);
	
	    List<Proiezione> findByDataFineBefore(LocalDate oggi);
}

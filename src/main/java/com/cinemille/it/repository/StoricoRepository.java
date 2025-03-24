package com.cinemille.it.repository;

import com.cinemille.it.domain.Proiezione;
import com.cinemille.it.domain.Storico;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Storico entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StoricoRepository extends JpaRepository<Storico, Long> {
	
	 Page<Storico> findByDataInizioBetween(LocalDate dataInizio, LocalDate dataFine, Pageable pageable);

	    Page<Storico> findByDataInizioAfter(LocalDate dataInizio, Pageable pageable);

	    Page<Storico> findByDataInizioBefore(LocalDate dataFine, Pageable pageable);
}

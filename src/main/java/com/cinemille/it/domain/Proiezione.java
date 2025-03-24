package com.cinemille.it.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A Proiezione.
 */
@Entity
@Table(name = "proiezione")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Proiezione implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProiezione")
    private Long id;

    @NotNull
    @Column(name = "dataProiezione", nullable = false)
    private LocalDate dataProiezione;

    @NotNull
    @Column(name = "dataFine", nullable = false)
    private LocalDate dataFine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "storicos", "proieziones","hibernateLazyInitializer", "handler"  }, allowSetters = true)
    @JoinColumn(name = "idFilm")  
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "proieziones", "cinema","hibernateLazyInitializer", "handler"  }, allowSetters = true)
    @JoinColumn(name = "idSala")
    private Sala sala;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Proiezione id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataProiezione() {
        return this.dataProiezione;
    }

    public Proiezione dataProiezione(LocalDate dataProiezione) {
        this.setDataProiezione(dataProiezione);
        return this;
    }

    public void setDataProiezione(LocalDate dataProiezione) {
        this.dataProiezione = dataProiezione;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public Proiezione dataFine(LocalDate dataFine) {
        this.setDataFine(dataFine);
        return this;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Film getFilm() {
        return this.film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Proiezione film(Film film) {
        this.setFilm(film);
        return this;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Proiezione sala(Sala sala) {
        this.setSala(sala);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proiezione)) {
            return false;
        }
        return getId() != null && getId().equals(((Proiezione) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Proiezione{" +
            "id=" + getId() +
            ", dataProiezione='" + getDataProiezione() + "'" +
            ", dataFine='" + getDataFine() + "'" +
            "}";
    }
}

package com.cinemille.it.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Storico.
 */
@Entity
@Table(name = "storico")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Storico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStorico")
    private Long id;

    @NotNull
    @Column(name = "dataInizio", nullable = false)
    private LocalDate dataInizio;

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

    public Storico id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Storico dataInizio(LocalDate dataInizio) {
        this.setDataInizio(dataInizio);
        return this;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public Storico dataFine(LocalDate dataFine) {
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

    public Storico film(Film film) {
        this.setFilm(film);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public Storico(Long id, @NotNull LocalDate dataInizio, @NotNull LocalDate dataFine, Film film, Sala sala) {
		super();
		this.id = id;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.film = film;
		this.sala = sala;
	}

	public Storico() {
		super();
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Storico)) {
            return false;
        }
        return getId() != null && getId().equals(((Storico) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Storico{" +
            "id=" + getId() +
            ", dataInizio='" + getDataInizio() + "'" +
            ", dataFine='" + getDataFine() + "'" +
            "}";
    }
}

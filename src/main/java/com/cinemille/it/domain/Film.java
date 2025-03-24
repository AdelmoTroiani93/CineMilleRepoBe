package com.cinemille.it.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Film.
 */
@Entity
@Table(name = "film")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFilm")
    private Long id;

    @NotNull
    @Column(name = "titolo", nullable = false)
    private String titolo;

    @NotNull
    @Column(name = "genere", nullable = false)
    private String genere;

    @NotNull
    @Column(name = "dataUscita", nullable = false)
    private LocalDate dataUscita;

    @NotNull
    @Column(name = "durata", nullable = false)
    private Integer durata;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    @JsonIgnoreProperties(value = { "film" }, allowSetters = true)
    private Set<Storico> storicos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    @JsonIgnoreProperties(value = { "film", "sala" }, allowSetters = true)
    private Set<Proiezione> proieziones = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Film id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public Film titolo(String titolo) {
        this.setTitolo(titolo);
        return this;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return this.genere;
    }

    public Film genere(String genere) {
        this.setGenere(genere);
        return this;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public LocalDate getDataUscita() {
        return this.dataUscita;
    }

    public Film dataUscita(LocalDate dataUscita) {
        this.setDataUscita(dataUscita);
        return this;
    }

    public void setDataUscita(LocalDate dataUscita) {
        this.dataUscita = dataUscita;
    }

    public Integer getDurata() {
        return this.durata;
    }

    public Film durata(Integer durata) {
        this.setDurata(durata);
        return this;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Set<Storico> getStoricos() {
        return this.storicos;
    }

    public void setStoricos(Set<Storico> storicos) {
        if (this.storicos != null) {
            this.storicos.forEach(i -> i.setFilm(null));
        }
        if (storicos != null) {
            storicos.forEach(i -> i.setFilm(this));
        }
        this.storicos = storicos;
    }

    public Film storicos(Set<Storico> storicos) {
        this.setStoricos(storicos);
        return this;
    }

    public Film addStorico(Storico storico) {
        this.storicos.add(storico);
        storico.setFilm(this);
        return this;
    }

    public Film removeStorico(Storico storico) {
        this.storicos.remove(storico);
        storico.setFilm(null);
        return this;
    }

    public Set<Proiezione> getProieziones() {
        return this.proieziones;
    }

    public void setProieziones(Set<Proiezione> proieziones) {
        if (this.proieziones != null) {
            this.proieziones.forEach(i -> i.setFilm(null));
        }
        if (proieziones != null) {
            proieziones.forEach(i -> i.setFilm(this));
        }
        this.proieziones = proieziones;
    }

    public Film proieziones(Set<Proiezione> proieziones) {
        this.setProieziones(proieziones);
        return this;
    }

    public Film addProiezione(Proiezione proiezione) {
        this.proieziones.add(proiezione);
        proiezione.setFilm(this);
        return this;
    }

    public Film removeProiezione(Proiezione proiezione) {
        this.proieziones.remove(proiezione);
        proiezione.setFilm(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Film)) {
            return false;
        }
        return getId() != null && getId().equals(((Film) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Film{" +
            "id=" + getId() +
            ", titolo='" + getTitolo() + "'" +
            ", genere='" + getGenere() + "'" +
            ", dataUscita='" + getDataUscita() + "'" +
            ", durata=" + getDurata() +
            "}";
    }
}

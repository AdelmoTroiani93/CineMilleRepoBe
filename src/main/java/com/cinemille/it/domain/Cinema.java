package com.cinemille.it.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Cinema.
 */
@Entity
@Table(name = "cinema")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCinema")
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "indirizzo")
    private String indirizzo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema")
    @JsonIgnoreProperties(value = { "proieziones", "cinema" }, allowSetters = true)
    private Set<Sala> salas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cinema id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public Cinema nome(String nome) {
        this.setNome(nome);
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public Cinema indirizzo(String indirizzo) {
        this.setIndirizzo(indirizzo);
        return this;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Set<Sala> getSalas() {
        return this.salas;
    }

    public void setSalas(Set<Sala> salas) {
        if (this.salas != null) {
            this.salas.forEach(i -> i.setCinema(null));
        }
        if (salas != null) {
            salas.forEach(i -> i.setCinema(this));
        }
        this.salas = salas;
    }

    public Cinema salas(Set<Sala> salas) {
        this.setSalas(salas);
        return this;
    }

    public Cinema addSala(Sala sala) {
        this.salas.add(sala);
        sala.setCinema(this);
        return this;
    }

    public Cinema removeSala(Sala sala) {
        this.salas.remove(sala);
        sala.setCinema(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cinema)) {
            return false;
        }
        return getId() != null && getId().equals(((Cinema) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cinema{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", indirizzo='" + getIndirizzo() + "'" +
            "}";
    }
}

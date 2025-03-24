package com.cinemille.it.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Sala.
 */
@Entity
@Table(name = "sala")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Long id;

    @NotNull
    @Column(name = "capienza", nullable = false)
    private Integer capienza;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @NotNull
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
    @JsonIgnoreProperties(value = { "film", "sala" }, allowSetters = true)
    private Set<Proiezione> proieziones = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
    @JsonIgnoreProperties(value = { "film", "sala" }, allowSetters = true)
    private Set<Storico> storicos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "salas" }, allowSetters = true) 
    @JoinColumn(name = "idCinema")
    private Cinema cinema;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Set<Storico> getStoricos() {
		return storicos;
	}

	public void setStoricos(Set<Storico> storicos) {
		this.storicos = storicos;
	}

	public Sala id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapienza() {
        return this.capienza;
    }

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sala capienza(Integer capienza) {
        this.setCapienza(capienza);
        return this;
    }

    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Sala tipo(String tipo) {
        this.setTipo(tipo);
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Proiezione> getProieziones() {
        return this.proieziones;
    }

    public void setProieziones(Set<Proiezione> proieziones) {
        if (this.proieziones != null) {
            this.proieziones.forEach(i -> i.setSala(null));
        }
        if (proieziones != null) {
            proieziones.forEach(i -> i.setSala(this));
        }
        this.proieziones = proieziones;
    }

    public Sala proieziones(Set<Proiezione> proieziones) {
        this.setProieziones(proieziones);
        return this;
    }

    public Sala addProiezione(Proiezione proiezione) {
        this.proieziones.add(proiezione);
        proiezione.setSala(this);
        return this;
    }

    public Sala removeProiezione(Proiezione proiezione) {
        this.proieziones.remove(proiezione);
        proiezione.setSala(null);
        return this;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Sala cinema(Cinema cinema) {
        this.setCinema(cinema);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sala)) {
            return false;
        }
        return getId() != null && getId().equals(((Sala) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Sala{" +
            "id=" + getId() +
            ", capienza=" + getCapienza() +
            ", tipo='" + getTipo() + "'" +
            "}";
    }
}

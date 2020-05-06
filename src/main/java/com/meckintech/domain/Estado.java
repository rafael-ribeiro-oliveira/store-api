package com.meckintech.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(final Integer id, final String nome, final List<Cidade> cidades) {
        this.id = id;
        this.nome = nome;
        this.cidades = cidades;
    }

    public Estado(final Integer id, final String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public Estado setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public Estado setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public List<Cidade> getCidades() {
        return this.cidades;
    }

    public Estado setCidades(final List<Cidade> cidades) {
        this.cidades = cidades;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Estado estado = (Estado) o;
        return this.getId().equals(estado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}


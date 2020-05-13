package com.meckintech.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;


    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade() {
    }

    public Cidade(final Integer id, final String nome, final Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }


    public Integer getId() {
        return this.id;
    }

    public Cidade setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public Cidade setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public Cidade setEstado(final Estado estado) {
        this.estado = estado;
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
        final Cidade cidade = (Cidade) o;
        return this.getId().equals(cidade.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}


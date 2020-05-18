package com.meckintech.DTO;

import com.meckintech.domain.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 805155494431769515L;

    private Integer id;
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(final Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return this.id;
    }

    public CategoriaDTO setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public CategoriaDTO setNome(final String nome) {
        this.nome = nome;
        return this;
    }
}

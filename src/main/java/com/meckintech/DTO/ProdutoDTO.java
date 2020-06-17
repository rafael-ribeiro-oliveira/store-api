package com.meckintech.DTO;

import com.meckintech.domain.Produto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO() {

    }

    public ProdutoDTO(final Produto obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
    }

    public Integer getId() {
        return this.id;
    }

    public ProdutoDTO setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public ProdutoDTO setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public Double getPreco() {
        return this.preco;
    }

    public ProdutoDTO setPreco(final Double preco) {
        this.preco = preco;
        return this;
    }
}

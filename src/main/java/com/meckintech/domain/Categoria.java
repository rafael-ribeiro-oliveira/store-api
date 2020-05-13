package com.meckintech.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 805155494431769515L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;


    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();


    public Categoria() {
    }

    public Categoria(final Integer id, final String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public Categoria setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public Categoria setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public Categoria setProdutos(final List<Produto> produtos) {
        this.produtos = produtos;
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
        final Categoria categoria = (Categoria) o;
        return this.getId().equals(categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }


}



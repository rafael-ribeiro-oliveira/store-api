package com.meckintech.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Produto extends Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private final Set<ItemPedido> itens = new HashSet<>();

    public Produto() {
    }

    public static long getSerialVersionUID() {
        return Produto.serialVersionUID;
    }

    public Set<ItemPedido> getItens() {
        return this.itens;
    }

    @JsonIgnore
    public List<Pedido> getPedidos() {
        final List<Pedido> lista = new ArrayList<>();
        for (final ItemPedido x : this.itens) {
            lista.add(x.getPedido());
        }
        return lista;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public Produto setId(final Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public Produto setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public Double getPreco() {
        return this.preco;
    }

    public Produto setPreco(final Double preco) {
        this.preco = preco;
        return this;
    }

    public List<Categoria> getCategorias() {
        return this.categorias;
    }

    public Produto setCategorias(final List<Categoria> categorias) {
        this.categorias = categorias;
        return this;
    }

    public Produto(final Integer id, final String nome, final Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Produto produto = (Produto) o;
        return this.getId().equals(produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}

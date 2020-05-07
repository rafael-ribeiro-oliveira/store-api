package com.meckintech.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

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

    public List<Pedido> getPedidos() {
        final List<Pedido> lista = new ArrayList<>();
        for (final ItemPedido x : this.itens) {
            lista.add(x.getPedido());
        }
        return lista;
    }

    public Integer getId() {
        return this.id;
    }

    public Produto setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

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

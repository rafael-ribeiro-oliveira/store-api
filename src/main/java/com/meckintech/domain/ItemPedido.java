package com.meckintech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 805155494431769515L;

    @JsonIgnore
    @EmbeddedId
    private final ItemPedidoPK id = new ItemPedidoPK();


    private Double desconto;
    private Integer quantidade;
    private Double preco;


    public ItemPedido() {
    }

    public ItemPedido(final Pedido pedido, final Produto produto, final Double desconto, final Integer quantidade, final Double preco) {
        super();
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return this.id.getPedido();
    }

    public Produto getProduto() {
        return this.id.getProduto();
    }

    public ItemPedidoPK getId() {
        return this.id;
    }

    public Double getDesconto() {
        return this.desconto;
    }

    public ItemPedido setDesconto(final Double desconto) {
        this.desconto = desconto;
        return this;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public ItemPedido setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Double getPreco() {
        return this.preco;
    }

    public ItemPedido setPreco(final Double preco) {
        this.preco = preco;
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
        final ItemPedido that = (ItemPedido) o;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}

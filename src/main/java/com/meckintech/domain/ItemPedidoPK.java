package com.meckintech.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 2631592293260094162L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


    public Pedido getPedido() {
        return this.pedido;
    }

    public ItemPedidoPK setPedido(final Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public ItemPedidoPK setProduto(final Produto produto) {
        this.produto = produto;
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
        final ItemPedidoPK that = (ItemPedidoPK) o;
        return this.getPedido().equals(that.getPedido()) &&
                this.getProduto().equals(that.getProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPedido(), this.getProduto());
    }
}

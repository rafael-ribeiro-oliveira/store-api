package com.meckintech.domain;

import com.meckintech.enumeration.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
    private static final long serialVersionUID = 805155494431769515L;

    @Id
    private Integer id;
    private Integer estado;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;


    public Pagamento() {
    }

    public Pagamento(final Integer id, final EstadoPagamento estado, final Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return this.id;
    }

    public Pagamento setId(final Integer id) {
        this.id = id;
        return this;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(this.estado);
    }

    public Pagamento setEstado(final EstadoPagamento estado) {
        this.estado = estado.getCod();
        return this;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public Pagamento setPedido(final Pedido pedido) {
        this.pedido = pedido;
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
        final Pagamento pagamento = (Pagamento) o;
        return this.getId().equals(pagamento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}

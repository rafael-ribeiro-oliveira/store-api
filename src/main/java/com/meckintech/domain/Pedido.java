package com.meckintech.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 805155494431769515L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM//yyy  HH:mm")
    private Date instante;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entraga_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.produto")
    private final Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public static long getSerialVersionUID() {
        return Pedido.serialVersionUID;
    }

    public Set<ItemPedido> getItens() {
        return this.itens;
    }

    public Pedido(final Integer id, final Date instante, final Cliente cliente, final Endereco enderecoDeEntrega) {
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Integer getId() {
        return this.id;
    }

    public Pedido setId(final Integer id) {
        this.id = id;
        return this;
    }

    public Date getInstante() {
        return this.instante;
    }

    public Pedido setInstante(final Date instante) {
        this.instante = instante;
        return this;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public Pedido setPagamento(final Pagamento pagamento) {
        this.pagamento = pagamento;
        return this;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Pedido setCliente(final Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Endereco getEnderecoDeEntrega() {
        return this.enderecoDeEntrega;
    }

    public Pedido setEnderecoDeEntrega(final Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
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
        final Pedido pedido = (Pedido) o;
        return this.getId().equals(pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}

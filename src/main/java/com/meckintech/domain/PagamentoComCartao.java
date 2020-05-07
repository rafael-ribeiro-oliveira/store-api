package com.meckintech.domain;

import com.meckintech.enumeration.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 805155494431769515L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(final Integer id, final EstadoPagamento estado, final Pedido pedido, final Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return this.numeroDeParcelas;
    }

    public PagamentoComCartao setNumeroDeParcelas(final Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
        return this;
    }
}

package com.meckintech.domain;

import com.meckintech.enumeration.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 805155494431769515L;

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto() {
        
    }

    public PagamentoComBoleto(final Object o, final EstadoPagamento pendente, final Pedido ped2, final Date parse) {
    }


    public PagamentoComBoleto(final Integer id, final EstadoPagamento estado,
                              final Pedido pedido, final Date dataVencimento, final Date dataPagemento) {
        super(id, estado, pedido);
        this.dataPagamento = dataPagemento;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public PagamentoComBoleto setDataVencimento(final Date dataVencimento) {
        this.dataVencimento = dataVencimento;
        return this;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public PagamentoComBoleto setDataPagamento(final Date dataPagamento) {
        this.dataPagamento = dataPagamento;
        return this;
    }
}

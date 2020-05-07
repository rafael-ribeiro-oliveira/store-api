package com.meckintech.enumeration;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private final int cod;
    private final String descricao;

    private EstadoPagamento(final int cod, final String descricao) {
        this.cod = cod;
        this.descricao = descricao;

    }

    public int getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static EstadoPagamento toEnum(final Integer cod) {
        if (cod == null) {
            return null;
        }
        for (final EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;

            }
        }
        throw new IllegalArgumentException("Id invalido:  " + cod);
    }

}

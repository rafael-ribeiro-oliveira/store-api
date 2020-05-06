package com.meckintech.enumeration;

public enum TipoCliente {


    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private final int cod;
    private final String descricao;

    private TipoCliente(final int cod, final String descricao) {
        this.cod = cod;
        this.descricao = descricao;

    }

    public int getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoCliente toEnum(final Integer cod) {
        if (cod == null) {
            return null;
        }
        for (final TipoCliente x : TipoCliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;

            }
        }
        throw new IllegalArgumentException("Id invalido:  " + cod);

    }
}

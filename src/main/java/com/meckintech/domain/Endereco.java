package com.meckintech.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 7771179062719354339L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    public Endereco() {

    }

    public Endereco(final Integer id, final String logradouro, final String numero, final String complemento,
                    final String bairro, final String cep, final Cliente cliente, final Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade = cidade;
    }

    public Integer getId() {
        return this.id;
    }

    public Endereco setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public Endereco setLogradouro(final String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return this.numero;
    }

    public Endereco setNumero(final String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public Endereco setComplemento(final String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return this.bairro;
    }

    public Endereco setBairro(final String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCep() {
        return this.cep;
    }

    public Endereco setCep(final String cep) {
        this.cep = cep;
        return this;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Endereco setCliente(final Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public Endereco setCidade(final Cidade cidade) {
        this.cidade = cidade;
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
        final Endereco endereco = (Endereco) o;
        return this.getId().equals(endereco.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}

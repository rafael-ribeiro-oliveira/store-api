package com.meckintech.DTO;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;

    public ClienteNewDTO() {
    }

    public String getNome() {
        return this.nome;
    }

    public ClienteNewDTO setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public ClienteNewDTO setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getCpfOuCnpj() {
        return this.cpfOuCnpj;
    }

    public ClienteNewDTO setCpfOuCnpj(final String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
        return this;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public ClienteNewDTO setTipo(final Integer tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public ClienteNewDTO setLogradouro(final String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return this.numero;
    }

    public ClienteNewDTO setNumero(final String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public ClienteNewDTO setComplemento(final String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return this.bairro;
    }

    public ClienteNewDTO setBairro(final String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCep() {
        return this.cep;
    }

    public ClienteNewDTO setCep(final String cep) {
        this.cep = cep;
        return this;
    }

    public String getTelefone1() {
        return this.telefone1;
    }

    public ClienteNewDTO setTelefone1(final String telefone1) {
        this.telefone1 = telefone1;
        return this;
    }

    public String getTelefone2() {
        return this.telefone2;
    }

    public ClienteNewDTO setTelefone2(final String telefone2) {
        this.telefone2 = telefone2;
        return this;
    }

    public String getTelefone3() {
        return this.telefone3;
    }

    public ClienteNewDTO setTelefone3(final String telefone3) {
        this.telefone3 = telefone3;
        return this;
    }

    public Integer getCidadeId() {
        return this.cidadeId;
    }

    public ClienteNewDTO setCidadeId(final Integer cidadeId) {
        this.cidadeId = cidadeId;
        return this;
    }
}

package com.meckintech.DTO;

import com.meckintech.service.validation.ClienteInsert;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@ClienteInsert
public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchemento obrigatório")
    @Email(message = "Email invalido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpfOuCnpj;


    private Integer tipo;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String logradouro;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String numero;

    private String complemento;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String bairro;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cep;

    @NotEmpty(message = "Preenchimento obrigatório")
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

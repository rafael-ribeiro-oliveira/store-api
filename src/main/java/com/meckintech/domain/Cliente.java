package com.meckintech.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.meckintech.enumeration.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = -1564318538334017678L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private final List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telefone")
    private final Set<String> telefones = new HashSet<>();


    @OneToMany(mappedBy = "cliente")
    private final List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(final Integer id, final String nome, final String email, final String cpfOuCnpj, final TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCod();
    }

    public Integer getId() {
        return this.id;
    }

    public Cliente setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public Cliente setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public Cliente setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getCpfOuCnpj() {
        return this.cpfOuCnpj;
    }

    public Cliente setCpfOuCnpj(final String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
        return this;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(this.tipo);
    }

    public Cliente setTipo(final TipoCliente tipo) {
        this.tipo = tipo.getCod();
        return this;
    }

    public List<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public Set<String> getTelefones() {
        return this.telefones;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Cliente cliente = (Cliente) o;
        return this.getId().equals(cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}


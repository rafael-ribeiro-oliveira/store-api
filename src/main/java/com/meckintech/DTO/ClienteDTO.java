package com.meckintech.DTO;

import com.meckintech.domain.Cliente;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    public String getCpfOuCnpj;

    private Integer id;
    private String nome;
    private String email;


    public ClienteDTO() {
    }

    public ClienteDTO(final Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();

    }

    public Integer getId() {
        return this.id;
    }

    public ClienteDTO setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public ClienteDTO setNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public ClienteDTO setEmail(final String email) {
        this.email = email;
        return this;
    }
    
}

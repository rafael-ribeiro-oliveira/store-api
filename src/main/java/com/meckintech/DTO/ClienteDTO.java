package com.meckintech.DTO;

import com.meckintech.domain.Cliente;
import com.meckintech.service.exception.validation.ClienteUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    public String getCpfOuCnpj;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchmento obrigatório")
    @Email(message = "Email invalido")
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

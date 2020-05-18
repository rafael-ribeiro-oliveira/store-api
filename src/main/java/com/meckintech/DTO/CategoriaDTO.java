package com.meckintech.DTO;

import com.meckintech.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 805155494431769515L;

    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;


    public CategoriaDTO() {
    }

    public CategoriaDTO(final Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return this.id;
    }

    public CategoriaDTO setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public CategoriaDTO setNome(final String nome) {
        this.nome = nome;
        return this;
    }
}

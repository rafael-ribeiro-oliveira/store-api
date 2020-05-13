package com.meckintech.service;

import com.meckintech.domain.Categoria;
import com.meckintech.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(final CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscar(final Integer id) {
        final Optional<Categoria> optionalCategoria = this.categoriaRepository.findById(id);
        return optionalCategoria
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                        + ", Tipo" + Categoria.class.getName()));
    }

    public Categoria insert(final Categoria obj) {
        obj.setId(null);
        return this.categoriaRepository.save(obj);
    }
}

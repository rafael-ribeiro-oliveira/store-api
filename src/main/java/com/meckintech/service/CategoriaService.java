package com.meckintech.service;

import com.meckintech.domain.Categoria;
import com.meckintech.repository.CategoriaRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscar(Integer id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                + ", Tipo" + Categoria.class.getName()));
    }
}

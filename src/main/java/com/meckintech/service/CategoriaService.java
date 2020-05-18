package com.meckintech.service;

import com.meckintech.domain.Categoria;
import com.meckintech.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(final CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria find(final Integer id) {
        final Optional<Categoria> optionalCategoria = this.categoriaRepository.findById(id);
        return optionalCategoria
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                        + ", Tipo" + Categoria.class.getName()));
    }

    public Categoria insert(final Categoria obj) {
        obj.setId(null);
        return this.categoriaRepository.save(obj);
    }

    public Categoria update(final Categoria obj) {
        this.find(obj.getId());
        return this.categoriaRepository.save(obj);
    }

    public void delete(final Integer id) {
        this.find(id);
        try {
            this.categoriaRepository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new com.meckintech.service.DataIntegrityViolationException("Não é possivel " +
                    "excluir uma categoria com produtos");
        }
    }

    public List<Categoria> findAll() {
        return this.categoriaRepository.findAll();
    }

}


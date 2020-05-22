package com.meckintech.service;

import com.meckintech.DTO.CategoriaDTO;
import com.meckintech.domain.Categoria;
import com.meckintech.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        final Categoria newObj = this.find(obj.getId());
        this.updateData(newObj, obj);
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

    public Page<Categoria> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction) {
        final PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return this.categoriaRepository.findAll(pageRequest);

    }

    public Categoria fromDTO(final CategoriaDTO objDto) {
        return new Categoria(objDto.getId(), objDto.getNome());

    }

    private void updateData(final Categoria newObj, final Categoria obj) {
        newObj.setNome(obj.getNome());
    }
}

package com.meckintech.service.exception;

import com.meckintech.domain.Categoria;
import com.meckintech.domain.Produto;
import com.meckintech.repository.CategoriaRepository;
import com.meckintech.repository.ProdutoRepository;
import com.meckintech.service.exception.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(final ProdutoRepository pedidoRepository, final CategoriaRepository categoriaRepository) {
        this.produtoRepository = pedidoRepository;
        this.categoriaRepository = categoriaRepository;
    }


    public Produto find(final Integer id) {
        final Optional<Produto> optionalProduto = this.produtoRepository.findById(id);
        return optionalProduto
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                        + ", Tipo" + Produto.class.getName()));
    }

    public Page<Produto> search(final String nome, final List<Integer> ids, final Integer page, final Integer linesPerPage, final String orderBy, final String direction) {
        final PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        {
            final List<Categoria> categorias = this.categoriaRepository.findAllById(ids);
            return this.produtoRepository.search(nome, categorias, pageRequest);
        }

    }
}

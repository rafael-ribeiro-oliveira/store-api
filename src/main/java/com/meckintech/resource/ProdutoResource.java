package com.meckintech.resource;

import com.meckintech.DTO.ProdutoDTO;
import com.meckintech.domain.Produto;
import com.meckintech.resource.utils.URL;
import com.meckintech.service.exception.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> find(@PathVariable final Integer id) {
        final Produto obj = this.service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> findPage(
            @RequestParam(value = "nome", defaultValue = "") final String nome,
            @RequestParam(value = "categorias", defaultValue = "") final String categorias,
            @RequestParam(value = "page", defaultValue = "0") final Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") final Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") final String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") final String direction) {
        final String nomeDecoded = URL.decodeParam(nome);
        final List<Integer> ids = URL.decodeIntList(categorias);
        final Page<Produto> list = this.service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
        final Page<ProdutoDTO> listDto = list.map(ProdutoDTO -> new ProdutoDTO(ProdutoDTO));
        return ResponseEntity.ok().body(listDto);
    }

}

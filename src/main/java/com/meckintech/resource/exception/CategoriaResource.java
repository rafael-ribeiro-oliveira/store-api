package com.meckintech.resource.exception;

import com.meckintech.DTO.CategoriaDTO;
import com.meckintech.domain.Categoria;
import com.meckintech.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> find(@PathVariable final Integer id) {
        final Categoria obj = this.categoriaService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid final @RequestBody CategoriaDTO objDto) {
        final Categoria obj = this.categoriaService.fromDTO(objDto);
        final Categoria categoria = this.categoriaService.insert(obj);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(final @RequestBody CategoriaDTO objDto, @PathVariable final Integer id) {
        final Categoria obj = this.categoriaService.fromDTO(objDto);
        obj.setId(id);
        final Categoria categoria = this.categoriaService.update(obj);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        final List<Categoria> categoriaList = this.categoriaService.findAll();
        final List<CategoriaDTO> categoriaDTOList = categoriaList.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoriaDTOList);

    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") final Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") final Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") final String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") final String direction) {
        final Page<Categoria> categoriaPage = this.categoriaService.findPage(page, linesPerPage, orderBy, direction);
        final Page<CategoriaDTO> listDto = categoriaPage.map(categoria -> new CategoriaDTO(categoria));
        return ResponseEntity.ok().body(listDto);

    }

}







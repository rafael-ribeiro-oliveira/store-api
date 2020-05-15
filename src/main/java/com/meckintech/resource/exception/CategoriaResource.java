package com.meckintech.resource.exception;

import com.meckintech.domain.Categoria;
import com.meckintech.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<Void> save(final @RequestBody Categoria obj) {
        final Categoria categoria = this.categoriaService.insert(obj);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(final @RequestBody Categoria obj, @PathVariable final Integer id) {
        obj.setId(id);
        final Categoria categoria = this.categoriaService.update(obj);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        this.categoriaService.delete(id);
        return ResponseEntity.noContent().build();

    }

}







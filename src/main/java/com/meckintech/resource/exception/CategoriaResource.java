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
    public ResponseEntity<?> find(@PathVariable final Integer id) {
        final Categoria obj = this.categoriaService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(final @RequestBody Categoria obj) {
        final Categoria categoria = this.categoriaService.insert(obj);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}


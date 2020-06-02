package com.meckintech.resource;

import com.meckintech.DTO.ClienteDTO;
import com.meckintech.DTO.ClienteNewDTO;
import com.meckintech.domain.Cliente;
import com.meckintech.service.exception.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;
    private Cliente obj;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> find(@PathVariable final Integer id) {
        final Cliente obj = this.clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<Cliente> find(@RequestParam(value = "value") final String email) {
        final Cliente obj = this.clienteService.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody final ClienteNewDTO objDto) {
        Cliente obj = this.clienteService.fromDTO(objDto);
        obj = this.clienteService.insert(obj);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody final ClienteDTO objDto, @PathVariable final Integer id) {
        Cliente obj = this.clienteService.fromDTO(objDto);
        obj.setId(id);
        obj = this.clienteService.update(obj);
        return ResponseEntity.noContent().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        this.clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") final Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") final Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") final String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") final String direction) {
        final Page<Cliente> categoriaPage = this.clienteService.findPage(page, linesPerPage, orderBy, direction);
        final Page<ClienteDTO> listDto = categoriaPage.map(categoria -> new ClienteDTO(this.obj));
        return ResponseEntity.ok().body(listDto);

    }
}


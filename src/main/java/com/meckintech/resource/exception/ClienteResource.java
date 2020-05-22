package com.meckintech.resource.exception;

import com.meckintech.DTO.ClienteDTO;
import com.meckintech.domain.Cliente;
import com.meckintech.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> find(@PathVariable final Integer id) {
        final Cliente obj = this.clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(final @RequestBody ClienteDTO objDto, @PathVariable final Integer id) {
        final Cliente obj = this.clienteService.fromDTO(objDto);
        obj.setId(id);
        final Cliente categoria = this.clienteService.update(obj);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        this.clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {
        final List<Cliente> categoriaList = this.clienteService.findAll();
        final List<ClienteDTO> categoriaDTOList = categoriaList.stream().map(categoria -> new ClienteDTO(categoria)).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoriaDTOList);

    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") final Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") final Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") final String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") final String direction) {
        final Page<Cliente> categoriaPage = this.clienteService.findPage(page, linesPerPage, orderBy, direction);
        final Page<ClienteDTO> listDto = categoriaPage.map(categoria -> new ClienteDTO(categoria));
        return ResponseEntity.ok().body(listDto);

    }
}


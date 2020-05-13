package com.meckintech.resource.exception;

import com.meckintech.domain.Cliente;
import com.meckintech.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> find(@PathVariable final Integer id) {
        final Cliente obj = this.service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}


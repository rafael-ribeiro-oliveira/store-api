package com.meckintech.resource.exception;

import com.meckintech.domain.Pedido;
import com.meckintech.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> find(@PathVariable final Integer id) {
        final Pedido obj = this.service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}

package com.meckintech.service;

import com.meckintech.domain.Pedido;
import com.meckintech.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(final PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscar(final Integer id) {
        final Optional<Pedido> optionalPedido = this.pedidoRepository.findById(id);
        return optionalPedido
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                        + ", Tipo" + Pedido.class.getName()));
    }
}
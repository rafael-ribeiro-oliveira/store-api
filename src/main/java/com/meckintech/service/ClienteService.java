package com.meckintech.service;

import com.meckintech.domain.Cliente;
import com.meckintech.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository categoriaRepository;

    @Autowired
    public ClienteService(final ClienteRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Cliente buscar(final Integer id) {
        final Optional<Cliente> optionalCategoria = this.categoriaRepository.findById(id);
        return optionalCategoria
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                        + ", Tipo" + Cliente.class.getName()));
    }
}

package com.meckintech.service;

import com.meckintech.DTO.ClienteDTO;
import com.meckintech.domain.Cliente;
import com.meckintech.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(final ClienteRepository categoriaRepository) {
        this.clienteRepository = categoriaRepository;
    }

    public Cliente find(final Integer id) {
        final Optional<Cliente> optionalCategoria = this.clienteRepository.findById(id);
        return optionalCategoria
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                        + ", Tipo" + Cliente.class.getName()));
    }

    public Cliente update(final Cliente obj) {
        final Cliente newObj = this.find(obj.getId());
        this.updateDat(newObj, obj);
        return this.clienteRepository.save(obj);
    }

    public void delete(final Integer id) {
        this.find(id);
        try {
            this.clienteRepository.deleteById(id);
        } catch (final org.springframework.dao.DataIntegrityViolationException e) {
            throw new com.meckintech.service.DataIntegrityViolationException("Não é possivel " +
                    "excluir porque há entidades relacioandas");
        }
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Page<Cliente> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction) {
        final PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return this.clienteRepository.findAll(pageRequest);

    }

    public Cliente fromDTO(final ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);


    }


    private void updateDat(final Cliente newObj, final Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());

    }

}


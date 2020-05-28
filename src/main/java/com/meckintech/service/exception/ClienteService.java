package com.meckintech.service.exception;

import com.meckintech.DTO.ClienteDTO;
import com.meckintech.DTO.ClienteNewDTO;
import com.meckintech.domain.Cidade;
import com.meckintech.domain.Cliente;
import com.meckintech.domain.Endereco;
import com.meckintech.enumeration.TipoCliente;
import com.meckintech.repository.CidadeRepository;
import com.meckintech.repository.ClienteRepository;
import com.meckintech.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public ClienteService() {
    }


    public Cliente find(final Integer id) {
        final Optional<Cliente> obj = this.clienteRepository.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Objeto nao encontrado! id:" + id
                    + ", Tipo" + Cliente.class.getName());

        }

        return obj.get();
    }


    @Transactional
    public Cliente insert(final Cliente obj) {
        obj.setId(null);
        this.clienteRepository.save(obj);
        this.enderecoRepository.saveAll(obj.getEnderecos());
        return obj;

    }

    public Cliente update(final Cliente obj) {
        final Cliente newObj = this.find(obj.getId());
        this.updateData(newObj, obj);
        return this.clienteRepository.save(newObj);
    }


    public void delete(final Integer id) {
        this.find(id);
        try {
            this.clienteRepository.deleteById(id);
        } catch (final org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possivel " +
                    "excluir porque há pedidos relacioandas");
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


    public Cliente fromDTO(final ClienteNewDTO objDto) {
        final Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
        final Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        final Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if (objDto.getTelefone2() != null) {
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if (objDto.getTelefone3() != null) {
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }


    private void updateData(final Cliente newObj, final Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());

    }

    public ClienteService setClienteRepository(final ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        return this;
    }
}


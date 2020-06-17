package com.meckintech.service.exception.validation;

import com.meckintech.DTO.ClienteNewDTO;
import com.meckintech.domain.Cliente;
import com.meckintech.enumeration.TipoCliente;
import com.meckintech.repository.ClienteRepository;
import com.meckintech.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(final ClienteInsert ann) {
    }

    @Override
    public boolean isValid(final ClienteNewDTO objDto, final ConstraintValidatorContext context) {

        final List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }
        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        final Cliente aux = this.clienteRepository.findByEmail((objDto.getEmail()));
        if (aux != null) {
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (final FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
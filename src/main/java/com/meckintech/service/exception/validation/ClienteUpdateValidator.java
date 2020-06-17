package com.meckintech.service.exception.validation;

import com.meckintech.DTO.ClienteDTO;
import com.meckintech.domain.Cliente;
import com.meckintech.repository.ClienteRepository;
import com.meckintech.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(final ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(final ClienteDTO objDto, final ConstraintValidatorContext context) {

        final Map<String, String> map = (Map<String, String>)
                this.request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        final Integer uriId = Integer.parseInt(map.get("id"));

        final List<FieldMessage> list = new ArrayList<>();


        final Cliente aux = this.clienteRepository.findByEmail((objDto.getEmail()));
        if (aux != null && !aux.getId().equals(uriId)) {
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
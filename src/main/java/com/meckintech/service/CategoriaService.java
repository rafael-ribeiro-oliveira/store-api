package com.meckintech.service;

import com.meckintech.domain.Categoria;
import com.meckintech.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

@Autowired
    private CategoriaRepository repo;

public Categoria buscar(Integer id) {
        Categoria obj = repo.findOne(id);
        return obj;
    }

}

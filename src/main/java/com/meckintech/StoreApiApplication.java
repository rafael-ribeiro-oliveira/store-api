package com.meckintech;

import com.meckintech.domain.Categoria;
import com.meckintech.domain.Cidade;
import com.meckintech.domain.Estado;
import com.meckintech.domain.Produto;
import com.meckintech.repository.CategoriaRepository;
import com.meckintech.repository.CidadeRepository;
import com.meckintech.repository.EstadoRepository;
import com.meckintech.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StoreApiApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRpository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;


    public StoreApiApplication() {
    }

    public static void main(final String[] args) {
        SpringApplication.run(StoreApiApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {

        final Categoria cat1 = new Categoria(null, "Informatica");
        final Categoria cat2 = new Categoria(null, "Escritorio");

        final Produto p1 = new Produto(null, "Computador", 2000.00);
        final Produto p2 = new Produto(null, "Impressora", 800.00);
        final Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        final Estado est1 = new Estado(null, "Minas Gerais");
        final Estado est2 = new Estado(null, "São Paulo");

        final Cidade c1 = new Cidade(null, "Uberlandia", est1);
        final Cidade c2 = new Cidade(null, "São Paulo", est2);
        final Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        this.produtoRpository.saveAll(Arrays.asList(p1, p2, p3));

        this.estadoRepository.saveAll(Arrays.asList(est1, est2));
        this.cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));


    }
}
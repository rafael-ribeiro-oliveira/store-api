package com.meckintech;

import com.meckintech.domain.*;
import com.meckintech.enumeration.EstadoPagamento;
import com.meckintech.enumeration.TipoCliente;
import com.meckintech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    

    public static void main(final String[] args) {
        SpringApplication.run(StoreApiApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {

        final Categoria cat1 = new Categoria(null, "Informatica");
        final Categoria cat2 = new Categoria(null, "Escritorio");
        final Categoria cat3 = new Categoria(null, "cama mesa e banho");
        final Categoria cat4 = new Categoria(null, "Eletrônicos");
        final Categoria cat5 = new Categoria(null, "Jardinagem");
        final Categoria cat6 = new Categoria(null, "Decoração");
        final Categoria cat7 = new Categoria(null, "Perfumaria");

        final Produto p1 = new Produto(null, "Computador", 2000.00);
        final Produto p2 = new Produto(null, "Impressora", 800.00);
        final Produto p3 = new Produto(null, "Mouse", 80.00);
        final Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
        final Produto p5 = new Produto(null, "Toalha", 50.00);
        final Produto p6 = new Produto(null, "Colcha", 200.00);
        final Produto p7 = new Produto(null, "TV true color", 1200.00);
        final Produto p8 = new Produto(null, "Roçadeira", 800.00);
        final Produto p9 = new Produto(null, "Abajour", 100.00);
        final Produto p10 = new Produto(null, "Pendente", 180.00);
        final Produto p11 = new Produto(null, "Shampoo", 90.00);


        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));


        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));


        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        this.produtoRpository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        final Estado est1 = new Estado(null, "Minas Gerais");
        final Estado est2 = new Estado(null, "São Paulo");

        final Cidade c1 = new Cidade(null, "Uberlandia", est1);
        final Cidade c2 = new Cidade(null, "São Paulo", est2);
        final Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));


        this.estadoRepository.saveAll(Arrays.asList(est1, est2));
        this.cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        final Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com",
                "36378912377", TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        final Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303",
                "Jardim", "38220834", cli1, c1);
        final Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800",
                "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        this.clienteRepository.saveAll(Arrays.asList(cli1));
        this.enderecoRepository.saveAll(Arrays.asList(e1, e2));

        final SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

        final Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        final Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        final Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        final Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        this.pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        this.pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        final ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        final ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        final ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        this.itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
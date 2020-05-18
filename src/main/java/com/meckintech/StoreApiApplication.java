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


    public StoreApiApplication() {
    }

    public static void main(final String[] args) {
        SpringApplication.run(StoreApiApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {

        final Categoria cat1 = new Categoria(null, "Informatica");
        final Categoria cat2 = new Categoria(null, "Escritorio");
        final Categoria cat3 = new Categoria(null, "Cama, Mesa e Banho");
        final Categoria cat4 = new Categoria(null, "Eletronicos");
        final Categoria cat5 = new Categoria(null, "Jardinagem ");
        final Categoria cat6 = new Categoria(null, "Decoração");
        final Categoria cat7 = new Categoria(null, "Perfumaria");

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

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        this.produtoRpository.saveAll(Arrays.asList(p1, p2, p3));

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
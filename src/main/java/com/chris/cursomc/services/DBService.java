package com.chris.cursomc.services;

import static java.util.Arrays.asList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.cursomc.domain.Categoria;
import com.chris.cursomc.domain.Cidade;
import com.chris.cursomc.domain.Cliente;
import com.chris.cursomc.domain.Endereco;
import com.chris.cursomc.domain.Estado;
import com.chris.cursomc.domain.ItemPedido;
import com.chris.cursomc.domain.Pagamento;
import com.chris.cursomc.domain.PagamentoComBoleto;
import com.chris.cursomc.domain.PagamentoComCartao;
import com.chris.cursomc.domain.Pedido;
import com.chris.cursomc.domain.Produto;
import com.chris.cursomc.domain.enums.EstadoPagamento;
import com.chris.cursomc.domain.enums.TipoCliente;
import com.chris.cursomc.repositories.CategoriaRepository;
import com.chris.cursomc.repositories.CidadeRepository;
import com.chris.cursomc.repositories.ClienteRepository;
import com.chris.cursomc.repositories.EnderecoRepository;
import com.chris.cursomc.repositories.EstadoRepository;
import com.chris.cursomc.repositories.ItemPedidoRepository;
import com.chris.cursomc.repositories.PagamentoRepository;
import com.chris.cursomc.repositories.PedidoRepository;
import com.chris.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;	
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository ;
	
	@Autowired
	private PagamentoRepository pagamentoRepository ;
	
	@Autowired
	private PedidoRepository pedidoRepository ;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateDatabase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
//		Categoria c = new Categoria(null, "teste");
		
//		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7  , c ));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "Tv true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajur", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

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

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		est1.getCidades().addAll(asList(cid1));
		est2.getCidades().addAll(asList(cid2,cid3));
		
		estadoRepository.saveAll(asList(est1, est2));
		cidadeRepository.saveAll(asList(cid1, cid2, cid3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "jeferson.c.mga@gmail.com", "363789412563", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(asList("9874564987","4897446465"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "382045470", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "08712450", cli1, cid2);
		
		cli1.getEnderecos().addAll(asList(end1, end2));
		
		clienteRepository.saveAll(asList(cli1));
		enderecoRepository.saveAll(asList(end1, end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);
		
		Pagamento pg1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pg1);
		
		Pagamento pg2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pg2);
		
		
		cli1.setPedidos(asList(ped1, ped2));
		
		pedidoRepository.saveAll(asList(ped1, ped2));
		
		pagamentoRepository.saveAll(asList(pg1, pg2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.0);
		
		ped1.getItens().addAll(asList(ip1, ip2));
		ped2.getItens().addAll(asList(ip3));
		
		p1.getItens().addAll(asList(ip1));
		p2.getItens().addAll(asList(ip3));
		p3.getItens().addAll(asList(ip2));
		
		itemPedidoRepository.saveAll(asList(ip1, ip2, ip3) );
	}

}
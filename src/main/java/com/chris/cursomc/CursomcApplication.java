package com.chris.cursomc;

import static java.util.Arrays.asList;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chris.cursomc.domain.Categoria;
import com.chris.cursomc.domain.Cidade;
import com.chris.cursomc.domain.Cliente;
import com.chris.cursomc.domain.Endereco;
import com.chris.cursomc.domain.Estado;
import com.chris.cursomc.domain.Produto;
import com.chris.cursomc.domain.enums.TipoCliente;
import com.chris.cursomc.repositories.CategoriaRepository;
import com.chris.cursomc.repositories.CidadeRepository;
import com.chris.cursomc.repositories.ClienteRepository;
import com.chris.cursomc.repositories.EnderecoRepository;
import com.chris.cursomc.repositories.EstadoRepository;
import com.chris.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
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
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(asList(p1, p2, p3));
		cat2.getProdutos().addAll(asList(p2));
		
		p1.getCategorias().addAll(asList(cat1, cat2));
		p2.getCategorias().addAll(asList(cat2));
		p3.getCategorias().addAll(asList(cat1));
		
		produtoRepository.saveAll(asList(p1, p2,p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		est1.getCidades().addAll(asList(cid1));
		est2.getCidades().addAll(asList(cid2,cid3));
		
		estadoRepository.saveAll(asList(est1, est2));
		cidadeRepository.saveAll(asList(cid1, cid2, cid3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "363789412563", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(asList("9874564987","4897446465"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "382045470", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "08712450", cli1, cid2);
		
		cli1.getEnderecos().addAll(asList(end1, end2));
		
		clienteRepository.saveAll(asList(cli1));
		enderecoRepository.saveAll(asList(end1, end2));
		
	}

}

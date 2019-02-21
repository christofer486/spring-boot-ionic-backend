package com.chris.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.cursomc.domain.Cliente;
import com.chris.cursomc.repositories.ClienteRepository;
import com.chris.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> lista = repo.findById(id);
		return lista.orElseThrow(() ->new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo " + Cliente.class.getName()));
	}

}

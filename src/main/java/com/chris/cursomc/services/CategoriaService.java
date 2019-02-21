package com.chris.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.cursomc.domain.Categoria;
import com.chris.cursomc.repositories.CategoriaRepository;
import com.chris.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> lista = repo.findById(id);
		return lista.orElseThrow(() ->new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}

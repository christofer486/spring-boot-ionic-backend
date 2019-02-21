package com.chris.cursomc.resources;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chris.cursomc.domain.Categoria;
import com.chris.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService srv;
	
	@RequestMapping(value="/{id}", method=GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = srv.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = srv.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = srv.update(obj);
		return ResponseEntity.noContent().build();
	}

}

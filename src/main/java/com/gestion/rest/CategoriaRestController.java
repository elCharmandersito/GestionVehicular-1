package com.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.Categoria;
import com.gestion.model.Producto;
import com.gestion.service.CategoriaServiceImpl;

@RestController
public class CategoriaRestController {
	
	@Autowired
	private CategoriaServiceImpl categoriaService;
	
	@PostMapping(value = "/categorias/agregar", produces = "application/json")
	public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria) {
		try {
			categoriaService.save(categoria);
			return new ResponseEntity<Categoria>(categoria,HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Categoria>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value= "/categorias", produces = "application/json")
	public ResponseEntity<List<Categoria>> getAllCategorias() {
		List<Categoria> categorias = categoriaService.getAllCategorias();
		if (!categorias.isEmpty()) {
			return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
		}
		return new ResponseEntity<List<Categoria>>(HttpStatus.NOT_FOUND);
	}

	// esto es una prube
	System.out.println("");
}

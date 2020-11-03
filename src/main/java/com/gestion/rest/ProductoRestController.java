package com.gestion.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.Producto;
import com.gestion.service.ProductoServiceImpl;

@RestController
public class ProductoRestController {
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@PostMapping(value = "", produces = "application/json")
	public ResponseEntity<Producto> addCategoria(@RequestBody Producto producto) {
		try {
			productoService.save(producto);
			return new ResponseEntity<Producto>(producto,HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		}
	}
}

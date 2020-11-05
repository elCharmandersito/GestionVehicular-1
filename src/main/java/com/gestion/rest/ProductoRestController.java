package com.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.Producto;
import com.gestion.service.ProductoServiceImpl;


@RestController
public class ProductoRestController {
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@PostMapping(value = "/productos", produces = "application/json")
	public ResponseEntity<Producto> addProducto(@RequestBody Producto producto) {
		try {
			productoService.save(producto);
			return new ResponseEntity<Producto>(producto,HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/productos/eliminar")
	public ResponseEntity<Producto> deleteProducto (@RequestParam int id) {	
		Producto productos = productoService.findByInt(id);	
		try {
			productoService.delete(id);
			System.out.println(productos.getId());
			return new ResponseEntity<Producto>(productos,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping(value= "/productos/buscar", produces = "application/json")
	public ResponseEntity<List<Producto>> findProductoByName(@RequestParam String nombre) {
		List<Producto> productos = productoService.findByNombre(nombre);
		if (!productos.isEmpty()) {
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		}
		return new ResponseEntity<List<Producto>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value= "/productos", produces = "application/json")
	public ResponseEntity<List<Producto>> getAllProductos() {
		List<Producto> productos = productoService.getAllProductos();
		if (!productos.isEmpty()) {
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		}
		return new ResponseEntity<List<Producto>>(HttpStatus.NOT_FOUND);
	}
	
}

package com.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.model.Cliente;
import com.gestion.service.ClienteServicelmpl;


@RestController
public class ClienteRestController {
	
	@Autowired
	private ClienteServicelmpl clienteService;
	
	@PostMapping(value = "/cliente", produces ="application/json")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
		
		try {
			clienteService.save(cliente);
			return new ResponseEntity<Cliente> (cliente, HttpStatus.CREATED);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping (value= "/cliente", produces = "application/json")
	public ResponseEntity<List<Cliente>> gettAllClientes(){
		
		List <Cliente> clientes = clienteService.getAllClientes();
		
		if(!clientes.isEmpty()) {
			return new ResponseEntity<List <Cliente>>(clientes,HttpStatus.OK);
		}
		return new ResponseEntity<List<Cliente>>(HttpStatus.NOT_FOUND);
			
	}

}

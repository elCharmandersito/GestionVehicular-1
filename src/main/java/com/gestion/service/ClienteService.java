package com.gestion.service;

import java.util.List;

import com.gestion.model.Cliente;

public interface ClienteService {
	
	void save(Cliente cliente) throws Exception;
	
	public List<Cliente> getAllClientes();

}


 
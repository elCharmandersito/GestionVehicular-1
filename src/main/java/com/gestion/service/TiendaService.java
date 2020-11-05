package com.gestion.service;


import com.gestion.model.Tienda;

import java.util.List;

public interface TiendaService {
	public List <Tienda> getAllTienda();
	void save(Tienda tienda) throws Exception;
}




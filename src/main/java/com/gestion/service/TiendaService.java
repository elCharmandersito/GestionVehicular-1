package com.gestion.service;


import com.gestion.model.Tienda;

import java.util.List;

public interface TiendaService {
	void save(Tienda tienda) throws Exception;
	List<Tienda> getAllTiendas();
}




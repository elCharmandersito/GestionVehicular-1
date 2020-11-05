package com.gestion.service;

import java.util.List;

import com.gestion.model.ListaDeDeseo;

public interface ListaDeDeseoService {

	void save(ListaDeDeseo ldd) throws Exception;
	
	public List<ListaDeDeseo> getAllList();
}

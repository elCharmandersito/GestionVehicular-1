package com.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.model.Producto;
import com.gestion.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public List<Producto> getAllProductos() {
		return repo.findAll();
	}
	
	@Transactional
	@Override
	public void save(Producto producto) throws Exception {
		if (producto == null) {
			throw new Exception();
		}
		try {
			repo.save(producto);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	

	
}

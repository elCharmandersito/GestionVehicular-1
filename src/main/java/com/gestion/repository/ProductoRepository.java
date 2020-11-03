package com.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	                   
}         

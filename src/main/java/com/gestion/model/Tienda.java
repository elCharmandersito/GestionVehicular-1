package com.gestion.model;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany; */




@Entity
public class Tienda {

	@Id
	private int id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column (name = "ciudad", length = 50)
	private String ciudad;
	
	/* REVISAR MANY TO MANY A PRODUCTOS
	 * @ManyToMany
	@JoinTable (name= "Producto_Tienda", joinColumns = @JoinColumn(name = "idTienda"),
	inverseJoinColumns = @JoinColumn (name = "idProducto" ))
	 List<Producto> productos;
	*/
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

  	
	
}

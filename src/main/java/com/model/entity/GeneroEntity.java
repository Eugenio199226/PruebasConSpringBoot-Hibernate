package com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="genero")
public class GeneroEntity {
	
	
	//Variables
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_genero;
		
		@Column(name="nombre_genero")	
		@NotNull
	private String nombre;
	
	public GeneroEntity(String nombre) {
			super();
			this.nombre = nombre;
	}
	public GeneroEntity() {
			super();
			// TODO Auto-generated constructor stub
	}
		
	
	public long getIdGenero() {
		return id_genero;
	}
	public void setIdGenero(long idGenero) {
		this.id_genero = idGenero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}

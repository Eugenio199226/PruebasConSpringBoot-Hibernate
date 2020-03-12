package com.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="plataforma")
public class PlataformaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_plataforma;
	@Column(name="nombre_plataforma")	
	@NotNull
	private String nombre;
	@Column(name="fecha_lanzamiento_plataforma")	
	private Date fecha_lanzamiento;
	@Column(name="fecha_descatalogada")	
	private Date fecha_descatalogada;
	public PlataformaEntity(String nombre, Date fecha_lanzamiento, Date fecha_descatalogada) {
		super();
		this.nombre = nombre;
		this.fecha_lanzamiento = fecha_lanzamiento;
		this.fecha_descatalogada = fecha_descatalogada;
	}
	public PlataformaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}
	public void setFecha_lanzamiento(Date fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}
	public Date getFecha_descatalogada() {
		return fecha_descatalogada;
	}
	public void setFecha_descatalogada(Date fecha_descatalogada) {
		this.fecha_descatalogada = fecha_descatalogada;
	}
	

}

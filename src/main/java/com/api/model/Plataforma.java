package com.api.model;

import java.util.Date;

public class Plataforma {
	
	private long id_plataforma;
	private String nombre;
	private Date fecha_lanzamiento;
	private Date fecha_descatalogada;
	public Plataforma( String nombre, Date fecha_lanzamiento, Date fecha_descatalogada) {
		super();
		this.nombre = nombre;
		this.fecha_lanzamiento = fecha_lanzamiento;
		this.fecha_descatalogada = fecha_descatalogada;
	}
	public Plataforma() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_plataforma() {
		return id_plataforma;
	}
	public void setId_plataforma(long id_plataforma) {
		this.id_plataforma = id_plataforma;
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

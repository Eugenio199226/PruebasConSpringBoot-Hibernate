package com.api.model;

import java.util.Date;

public class Videojuego {
	
	private long id_videojuego;
	private String nombre;
	private long idgenero;
	private long idplataforma;
	private long puntuacion;
	private String resumen;
	private Date fecha_lanzamiento;
	public long getId_videojuego() {
		return id_videojuego;
	}
	public void setId_videojuego(long id_videojuego) {
		this.id_videojuego = id_videojuego;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getIdgenero() {
		return idgenero;
	}
	public void setIdgenero(long idgenero) {
		this.idgenero = idgenero;
	}
	public long getIdplataforma() {
		return idplataforma;
	}
	public void setIdplataforma(long idplataforma) {
		this.idplataforma = idplataforma;
	}
	public long getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(long puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public Date getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}
	public void setFecha_lanzamiento(Date fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}
	public Videojuego() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Videojuego(String nombre, long idgenero, long idplataforma, long puntuacion, String resumen,
			Date fecha_lanzamiento) {
		super();
		this.nombre = nombre;
		this.idgenero = idgenero;
		this.idplataforma = idplataforma;
		this.puntuacion = puntuacion;
		this.resumen = resumen;
		this.fecha_lanzamiento = fecha_lanzamiento;
	}
	
	

}

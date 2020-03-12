package com.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="videojuego")
public class VideojuegoEntity {

	public VideojuegoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_videojuego;
	@Column(name="nombre_videojuego")	
	@NotNull
	private String nombre;
	@Column(name="id_genero_videojuego")	
	@NotNull
	private long idgenero;
	@Column(name="id_plataforma_videojuego",nullable=false)
	private long idplataforma;
	@Column(name="puntuacion")	
	private long puntuacion;
	@Column(name="resumen")	
	private String resumen;
	@Column(name="fecha_lanzamiento_videojuego")	
	private Date fecha_lanzamiento;
	
	
	
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinTable(name = "genero_plataforma", joinColumns = { @JoinColumn(name = "id_genero_videojuego"), @JoinColumn(name = "id_plataforma_videojuego")}, inverseJoinColumns = {
			@JoinColumn(name = "id_genero"),@JoinColumn(name = "id_plataforma") })
	

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
	public VideojuegoEntity(String nombre, long idgenero, long idplataforma, long puntuacion, String resumen,
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

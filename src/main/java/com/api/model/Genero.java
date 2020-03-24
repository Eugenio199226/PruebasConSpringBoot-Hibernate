package com.api.model;

public class Genero {
	//Variables

		public Genero() {
		super();
		// TODO Auto-generated constructor stub
		}
		public Genero(long idGenero, String nombre) {
			super();
			this.nombre = nombre;
		}
		

		private long idGenero;
			

		private String nombre;
		
		
		public long getIdGenero() {
			return idGenero;
		}
		public void setIdGenero(long idGenero) {
			this.idGenero = idGenero;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
	
}

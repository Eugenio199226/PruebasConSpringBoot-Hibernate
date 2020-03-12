package com.api.model;

public class RelacionVideojuegoPlataformaGenero {
	
	private String nombre_videojuego;
	private String nombre_plataforma;
	private String nombre_genero;
	
	
	public RelacionVideojuegoPlataformaGenero(String nombre_videojuego, String nombre_plataforma,
			String nombre_genero) {
		super();
		this.nombre_videojuego = nombre_videojuego;
		this.nombre_plataforma = nombre_plataforma;
		this.nombre_genero = nombre_genero;
	}
	public String getNombre_videojuego() {
		return nombre_videojuego;
	}
	public void setNombre_videojuego(String nombre_videojuego) {
		this.nombre_videojuego = nombre_videojuego;
	}
	public String getNombre_plataforma() {
		return nombre_plataforma;
	}
	public void setNombre_plataforma(String nombre_plataforma) {
		this.nombre_plataforma = nombre_plataforma;
	}
	public String getNombre_genero() {
		return nombre_genero;
	}
	public void setNombre_genero(String nombre_genero) {
		this.nombre_genero = nombre_genero;
	}
	
	@Override
	public String toString() {
        return (char) 34+"nombre_videojuego"+(char) 34+":"+(char) 34+"nombre_videojuego" 
        		+(char) 34+ ","+(char) 34+" nombre_plataforma"+(char) 34+":" +(char) 34+ nombre_plataforma +(char) 34+ ","+(char) 34+" nombre_genero"+(char) 34+":"+ (char) 34 
        		+ nombre_genero+(char) 34;
        
    }


}

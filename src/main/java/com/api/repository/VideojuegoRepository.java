package com.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.entity.VideojuegoEntity;

@Repository
public interface VideojuegoRepository  extends JpaRepository<VideojuegoEntity, Long> {
	public VideojuegoEntity save(Optional<VideojuegoEntity> gen);
    @Query(value = "select  videojuego.nombre_videojuego as nombreVideojuego,genero.nombre_genero as nombreGenero,plataforma.nombre_plataforma as nombrePlataforma from videojuego " + 
    		"INNER JOIN genero  on videojuego.id_genero_videojuego=genero.id_genero " + 
    		"INNER JOIN plataforma on videojuego.id_plataforma_videojuego = plataforma.id_Plataforma", nativeQuery = true)
    List<String> selectWithOtherTables();
}

package com.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.PlataformaEntity;
import com.model.entity.VideojuegoEntity;

@Repository
public interface VideojuegoRepository  extends JpaRepository<VideojuegoEntity, Long> {
	public VideojuegoEntity save(Optional<VideojuegoEntity> gen);
	//Select modificado
    @Query(value = "select  videojuego.nombre_videojuego as nombreVideojuego,genero.nombre_genero as nombreGenero,plataforma.nombre_plataforma as nombrePlataforma from videojuego " + 
    		"INNER JOIN genero  on videojuego.id_genero_videojuego=genero.id_genero " + 
    		"INNER JOIN plataforma on videojuego.id_plataforma_videojuego = plataforma.id_Plataforma", nativeQuery = true)
    List<String> selectWithOtherTables();
  //Select modificado
    @Query(value = "select * from videojuego g where g.nombre_videojuego LIKE ?1%", nativeQuery = true)
    List<VideojuegoEntity> searcher(String name);
  //Delete modificado
	@Transactional
	 @Modifying
	 @Query(value="DELETE FROM videojuego g where g.nombre_videojuego=?1",nativeQuery=true)
    public void deleteByName(String name);
	@Query(value = "select * from plataforma g where g.nombre_plataforma = ?1", nativeQuery = true)
	public Optional<VideojuegoEntity> findByName(String name);
}

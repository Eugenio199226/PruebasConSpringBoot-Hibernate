package com.api.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.PlataformaEntity;



@Repository
public interface PlataformaRepository  extends JpaRepository<PlataformaEntity, Long> {
	public PlataformaEntity save(Optional<PlataformaEntity> gen);
	@Query(value = "select * from plataforma g where g.nombre_plataforma LIKE ?1%", nativeQuery = true)
	public List<PlataformaEntity> searcher(String name);
	@Query(value = "select * from plataforma g where g.nombre_plataforma = ?1", nativeQuery = true)
	public Optional<PlataformaEntity> findByName(String name);
	@Transactional
	 @Modifying
	 @Query(value="DELETE FROM plataforma g where g.nombre_plataforma=?1",nativeQuery=true)
	public void deleteByName(String name);

}

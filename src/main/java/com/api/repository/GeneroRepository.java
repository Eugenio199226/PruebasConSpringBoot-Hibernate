package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.GeneroEntity;

@Repository
public interface GeneroRepository  extends JpaRepository<GeneroEntity, Long> {
	 @Transactional
	 @Modifying
	 @Query(value="DELETE FROM genero g where g.nombre_genero=?1",nativeQuery=true)
	public void deletebyName(String nombre);
	 @Transactional
	 @Modifying
	 @Query(value="UPDATE genero set nombre_genero=?1 where nombre_genero=?2",nativeQuery=true)
	public void updatebyName(String valor,String nombre);
	 @Query(value = "select * from genero g where g.nombre_genero LIKE ?1%", nativeQuery = true)
	 public List<GeneroEntity> findByName(String name);

}

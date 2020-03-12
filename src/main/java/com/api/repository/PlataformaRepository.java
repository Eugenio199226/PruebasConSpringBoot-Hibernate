package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.entity.PlataformaEntity;



@Repository
public interface PlataformaRepository  extends JpaRepository<PlataformaEntity, Long> {
	public PlataformaEntity save(Optional<PlataformaEntity> gen);

}

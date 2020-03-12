package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.entity.GeneroEntity;

@Repository
public interface GeneroRepository  extends JpaRepository<GeneroEntity, Long> {
	public GeneroEntity save(Optional<GeneroEntity> gen);
}

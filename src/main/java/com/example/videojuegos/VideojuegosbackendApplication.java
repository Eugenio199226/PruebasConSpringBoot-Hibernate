package com.example.videojuegos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.controller.GeneroController;
import com.api.repository.GeneroRepository;
import com.model.entity.GeneroEntity;



//Clase de arranque para boot spring
@SpringBootApplication
//Se define la ubicación del controlador
@ComponentScan(basePackageClasses=GeneroController.class)
//Se define la ubicación de la clase repositorio
@EnableJpaRepositories(basePackageClasses=GeneroRepository.class)
//Se define la ubicación de la clase entity
@EntityScan(basePackageClasses=GeneroEntity.class)
public class VideojuegosbackendApplication implements CommandLineRunner{
	
	private static Logger LOG = LoggerFactory.getLogger(VideojuegosbackendApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(VideojuegosbackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("Se ejecuta la Api");
	}

}

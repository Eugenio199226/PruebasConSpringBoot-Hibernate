package com.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Genero;
import com.api.repository.GeneroRepository;
import com.example.videojuegos.VideojuegosbackendApplication;
import com.model.entity.GeneroEntity;

//Anotación que indica a spring boot que es un controlador
@RestController
//Raiz de la dirección de la api
@RequestMapping("/api")
public class GeneroController {
	private static Logger LOG = LoggerFactory.getLogger(VideojuegosbackendApplication.class);
	@Autowired
	private GeneroRepository genrep;
	
	//Grabar
	@PostMapping("/genero/grabar")
	public ResponseEntity<GeneroEntity> createGenero( @RequestBody Genero gen)
	{	
		LOG.info("Creating Genero....");
		GeneroEntity data = new GeneroEntity(gen.getNombre());
		GeneroEntity generoGuardado = genrep.save(data);
		LOG.info("Created Genero....");
		return  ResponseEntity.ok().body(generoGuardado);
	}
	//Lista Generos
	@GetMapping("/generos")
	public ResponseEntity<List<GeneroEntity>> getallGeneros()
	{
		LOG.info("Loading Generos....");
		List<GeneroEntity> generos = genrep.findAll();
		LOG.info("Loaded Generos....");
		return ResponseEntity.ok().body(generos);
	}
	//Lista Generos por id
	/*@GetMapping("/genero/{id}")
	public ResponseEntity<Optional<GeneroEntity>> getGenerobyId(@PathVariable(value="id") Long genId)
	{
		LOG.info("Loading Genero....");
		Optional<GeneroEntity> gen=genrep.findById(genId);
		LOG.info("Loaded Genero....");
		return ResponseEntity.ok().body(gen);
		
	}*/
	//Lista Generos por nombre
	@GetMapping("/genero/buscador/{nombre}")
	public ResponseEntity<List<GeneroEntity>> getAllValuesByName(@PathVariable(value="name") String name)
	{
		LOG.info("Loading Generos....");
		List<GeneroEntity> generos = genrep.findByName(name);
		LOG.info("Loaded Generos....");
		return ResponseEntity.ok().body(generos);
	}
	//Modificar
	@PutMapping("/generos/actualizar/{id}")
	public ResponseEntity<GeneroEntity> updateGenero(@PathVariable(value="id") Long genId,@Valid @RequestBody Genero genDetails)
	{
		LOG.info("Updating Genero....");
		Optional<GeneroEntity> gen=genrep.findById(genId);
		gen.get().setNombre(genDetails.getNombre());
		GeneroEntity generoActualizado = gen.get();
		GeneroEntity actualizarGenero=genrep.save(generoActualizado);
		LOG.info("Updated Genero....");
		return ResponseEntity.ok().body(actualizarGenero);
	}
	//Borrar
	/*@DeleteMapping("/genero/borrar/{id}")
		public ResponseEntity<GeneroEntity> borrarGenero(@PathVariable(value="id")Long genid)
	{
		LOG.info("Deleting Genero....");
		genrep.deleteById(genid);
		LOG.info("Deleted Genero....");
		return ResponseEntity.ok().build();
	}*/
	//Borrar por nombre
	@DeleteMapping("/genero/borrar/{name}")
	public ResponseEntity<GeneroEntity> borrarPorNombre(@PathVariable(value="name")String name)
	{
		LOG.info("Deleting Genero....");
		genrep.deletebyName(name);
		LOG.info("Deleted Genero....");
		
		return ResponseEntity.ok().build();
	}

	

}

package com.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Plataforma;
import com.api.repository.PlataformaRepository;
import com.example.videojuegos.VideojuegosbackendApplication;
import com.model.entity.PlataformaEntity;

//Anotación que indica a spring boot que es un controlador
@RestController
//Raiz de la dirección de la api
@RequestMapping("/api")
public class PlataformaController {
	private static Logger LOG = LoggerFactory.getLogger(VideojuegosbackendApplication.class);
	@Autowired
	private PlataformaRepository platrep;
	
	//Grabar
		@PostMapping("/plataforma/grabar")
		public ResponseEntity<PlataformaEntity> newPlataforma(@RequestBody Plataforma plat)
		{
			LOG.info("Creating Plataforma....");
			PlataformaEntity data = new PlataformaEntity(plat.getNombre(),plat.getFecha_lanzamiento(),plat.getFecha_descatalogada());
			PlataformaEntity plataformaSave = platrep.save(data);
			LOG.info("Created Plataforma....");
			return ResponseEntity.ok().body(plataformaSave);
		}
	// Lista Plataforma por id
		@GetMapping("/plataforma/{id}")
		public ResponseEntity<Optional<PlataformaEntity>> getPlataformabyId(@PathVariable(value="id") Long platId)
		{
			LOG.info("Loading Plataforma....");
			Optional<PlataformaEntity> plat = platrep.findById(platId);
			LOG.info("Loaded Plataforma....");
			return ResponseEntity.ok().body(plat);
		}
	//Lista Plataformas
	@GetMapping("/plataformas")
	public ResponseEntity<List<PlataformaEntity>> getAllPlataformas()
	{
		LOG.info("Loading Plataformas....");
		List<PlataformaEntity> plataformas = (List<PlataformaEntity>) platrep.findAll();
		LOG.info("Loaded Plataformas....");
		return ResponseEntity.ok().body(plataformas);
	}
	//Modificar
	@PutMapping("/plataforma/actualizar/{id}")
	public ResponseEntity<PlataformaEntity> updateEntity(@PathVariable(value="id")Long platId,@Valid @RequestBody Plataforma platDetails)
	{
		LOG.info("Updating Plataforma....");
		Optional<PlataformaEntity> plat =platrep.findById(platId);
		plat.get().setNombre(platDetails.getNombre());
		plat.get().setFecha_lanzamiento(platDetails.getFecha_lanzamiento());
		plat.get().setFecha_descatalogada(platDetails.getFecha_descatalogada());
		PlataformaEntity plataformaActualizada = plat.get();
		PlataformaEntity actualizarPlataforma=platrep.save(plataformaActualizada);
		LOG.info("Updated Plataforma....");
		return ResponseEntity.ok().body(actualizarPlataforma);
	}
	//Borrar
	@DeleteMapping("/plataforma/borrar/{id}")
	public ResponseEntity<PlataformaEntity> borrarPlataforma(@PathVariable(value="id")Long platid)
	{
		LOG.info("Deleting Plataforma....");
		Optional<PlataformaEntity> plat=platrep.findById(platid);
		platrep.deleteById(platid);
		LOG.info("Deleted Plataforma....");
		return ResponseEntity.ok().build();
	}
		

}

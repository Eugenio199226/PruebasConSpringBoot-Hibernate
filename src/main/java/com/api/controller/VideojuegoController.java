package com.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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

import com.api.model.RelacionVideojuegoPlataformaGenero;
import com.api.model.Videojuego;
import com.api.repository.VideojuegoRepository;
import com.example.videojuegos.VideojuegosbackendApplication;
import com.model.entity.VideojuegoEntity;

//Anotación que indica a spring boot que es un controlador
@RestController
//Raiz de la dirección de la api
@RequestMapping("/api")
public class VideojuegoController {
	private static Logger LOG = LoggerFactory.getLogger(VideojuegosbackendApplication.class);
	@Autowired
	private VideojuegoRepository vidrep;

	// Grabar
	@PostMapping("/videojuego/grabar")
	public ResponseEntity<VideojuegoEntity> createVideojuego(@RequestBody Videojuego vid) {
		LOG.info("Sending Insert....");
		VideojuegoEntity data = new VideojuegoEntity(vid.getNombre(), vid.getIdgenero(), vid.getIdplataforma(),
				vid.getPuntuacion(), vid.getResumen(), vid.getFecha_lanzamiento());
		VideojuegoEntity videojuegoGuardado = vidrep.save(data);
		LOG.info("Sended Insert....");
		return ResponseEntity.ok().body(videojuegoGuardado);
	}

	// Lista Videojuegos
	@GetMapping("/videojuegos")
	public ResponseEntity<List<VideojuegoEntity>> getallVideojuegos() {
		LOG.info("Loading List....");
		List<VideojuegoEntity> Videojuegos = vidrep.findAll();
		LOG.info("Loaded List....");
		return ResponseEntity.ok().body(Videojuegos);
	}

	// Lista Videojuegos por id
	@GetMapping("/videojuego/{id}")
	public ResponseEntity<Optional<VideojuegoEntity>> getVideojuegobyId(@PathVariable(value = "id") Long vidId) {
		LOG.info("Loading a Videojuego....");
		Optional<VideojuegoEntity> vid = vidrep.findById(vidId);
		LOG.info("Loaded a Videojuego....");
		return ResponseEntity.ok().body(vid);

	}

	// Modificar
	@PutMapping("/videojuegos/actualizar/{id}")
	public ResponseEntity<VideojuegoEntity> updateVideojuego(@PathVariable(value = "id") Long vidId,
			@Valid @RequestBody Videojuego vidDetails) {
		LOG.info("Updating Videojuego....");
		Optional<VideojuegoEntity> vid = vidrep.findById(vidId);
		vid.get().setNombre(vidDetails.getNombre());
		VideojuegoEntity videojuegoActualizado = vid.get();
		VideojuegoEntity actualizarVideojuego = vidrep.save(videojuegoActualizado);
		LOG.info("Updated Videojuego....");
		return ResponseEntity.ok().body(actualizarVideojuego);
	}

	// Borrar
	@DeleteMapping("/videojuego/borrar/{id}")
	public ResponseEntity<VideojuegoEntity> borrarVideojuego(@PathVariable(value = "id") Long vidId) {

		vidrep.deleteById(vidId);
		LOG.info("Deleting Videojuego....");
		return ResponseEntity.ok().build();
	}

	// Select personalizada para ver las tablas relacionadas con el videojuego
	@GetMapping("/videojuegosWithGenerosPlataformas")
	public ResponseEntity<Object> getallVideojuegosWithOtherTables() {
		// Se crea el string de salida
		String jsonSalida = "";
		// se llama al objeto para generar el json
		ObjectMapper mapperObj = new ObjectMapper();
		List<String> relaciones = vidrep.selectWithOtherTables();
		LOG.info("Loading element....");
		for (String relacion : relaciones) {
			String[] campos = relacion.split(",");
			RelacionVideojuegoPlataformaGenero rvpj = new RelacionVideojuegoPlataformaGenero(campos[0], campos[1],
					campos[2]);
			
			try {
				if (jsonSalida.equals("")) {
					jsonSalida = "[";
					jsonSalida += mapperObj.writeValueAsString(rvpj);
				} else {
					jsonSalida += "," + mapperObj.writeValueAsString(rvpj);
				}

			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error("Json Failed....");
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error("Json Mapping Failed....");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error("IO Failed....");
			}
			
		}
		LOG.info("Elements Loads....");
		jsonSalida += "]";

		return ResponseEntity.ok().body(jsonSalida);
	}
}

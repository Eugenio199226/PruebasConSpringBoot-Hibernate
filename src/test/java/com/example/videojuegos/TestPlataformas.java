package com.example.videojuegos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.repository.PlataformaRepository;
import com.model.entity.GeneroEntity;
import com.model.entity.PlataformaEntity;

@SpringBootTest
public class TestPlataformas {
	@Autowired
	private PlataformaRepository platrep;
	@Test
	public void testACreateGenero() 
	{
		Date date = null;
		PlataformaEntity data = new PlataformaEntity("prueba",date,date);
		PlataformaEntity plataformaSave  = platrep.save(data);
		assertThat(plataformaSave.getNombre())
	      .isEqualTo("prueba");
	}
	@Test
	public void TestBbuscador() 
	{
		 List<PlataformaEntity> found = platrep.searcher("prueba");
		 
		    // then
		    assertThat(found.isEmpty())
		      .isEqualTo(false);
	}
	@Test
	public void TestCModificarPlataforma() 
	{
		Date data = new Date();
		try {
		Optional<PlataformaEntity> plat =platrep.findByName("prueba");
		plat.get().setNombre("prueba2");

		plat.get().setFecha_lanzamiento(data);
		plat.get().setFecha_descatalogada(data);


		PlataformaEntity plataformaActualizada = plat.get();
		platrep.save(plataformaActualizada);
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		  assertThat(platrep.count())
	      .isEqualTo(2);
	}
	@Test
	public void TestZBorrar() 
	{
		try {
			platrep.deleteByName("prueba2");
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	    // then
	    assertThat(platrep.count())
	      .isEqualTo(1);
	}
}

package com.example.videojuegos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.repository.GeneroRepository;
import com.model.entity.GeneroEntity;

@SpringBootTest
class VideojuegosbackendApplicationTests {
	@Autowired
	private GeneroRepository genrep;
	@Test
	public void testACreateGenero() 
	{
		GeneroEntity data = new GeneroEntity("prueba");
		GeneroEntity generoGuardado = genrep.save(data);
		assertThat(generoGuardado.getNombre())
	      .isEqualTo("prueba");
	}
	@Test
	public void testBGenerosFindAll() 
	{
		 // when
		 List<GeneroEntity> found = genrep.findAll();
		 
		    // then
		    assertThat(found.isEmpty())
		      .isEqualTo(false);
	}

	/*@Test
	public void testGenerosFindId() 
	{
		 // when
		 Optional<GeneroEntity> found = genrep.findById((long)75);

		    // then
		    assertThat(found.get().getNombre())
		      .isEqualTo("prueba");
	}*/
	@Test
	public void testCGenerosFindName() 
	{
		// when
				 List<GeneroEntity> found = genrep.findByName("pru");
				 
				    // then
				    assertThat(found.isEmpty())
				      .isEqualTo(false);
	}
	@Test
	public void testDGenerosUpdate() 
	{
		// when
		try {
		genrep.updatebyName("prueba2","prueba");
				 
				    // then
				    assertThat(genrep.count())
				      .isEqualTo(2);
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test
	public void testEGeneroDeleteByName() 
	{
		try {
		genrep.deletebyName("prueba2");
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	    // then
	    assertThat(genrep.count())
	      .isEqualTo(2);
	}

}

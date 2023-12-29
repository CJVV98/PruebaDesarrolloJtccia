package net.jaimetorres.pruebades.testunit;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.jaimetorres.pruebades.entity.Paciente;
import net.jaimetorres.pruebades.repository.PacienteRepository;


@RunWith(SpringRunner.class )
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RepositoryTest {

	 @Autowired
	 PacienteRepository pacienteRepository;
	 
	 @Test
	 @Transactional
	 public void insertarPaciente() {
		Paciente paciente=new Paciente();
		paciente.setApellido("Romero");
		paciente.setNombre("Juan");
		paciente.setNroIdentificacion("12500300");
		paciente.setEdad(23);
		paciente.setGenero("F");
		pacienteRepository.save(paciente);
		assertNotNull(paciente.getId());
		
	}
	 
}

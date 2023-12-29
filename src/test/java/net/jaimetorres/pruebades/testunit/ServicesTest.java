package net.jaimetorres.pruebades.testunit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.jaimetorres.pruebades.dto.CitaDto;
import net.jaimetorres.pruebades.dto.PacienteDto;
import net.jaimetorres.pruebades.dto.ResponseJson;
import net.jaimetorres.pruebades.services.CitaServices;


@SpringBootTest
public class ServicesTest {

	@Autowired
	CitaServices citaServices;
	
	@Test
	public void obtenerCitas() {
		ResponseJson response= citaServices.consultarAgenda("2023-12-28", "10:00:00", "12:00:00");
		assertEquals(response.getObjeto() != null, true);
		List<CitaDto> citas=(List<CitaDto>) response.getObjeto();
		assertTrue(citas.size()>0);
	}
	
	@Test
	public void consultarPaciente() {
		PacienteDto paciente=new PacienteDto();
		paciente.setNroIdentificacion("109090");
		ResponseJson response= citaServices.consultarMedicamentos(paciente);
		assertEquals(response.getObjeto() != null, true);
	
	}
}

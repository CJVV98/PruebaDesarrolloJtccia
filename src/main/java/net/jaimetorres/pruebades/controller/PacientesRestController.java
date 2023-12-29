package net.jaimetorres.pruebades.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.jaimetorres.pruebades.dto.PacienteDto;
import net.jaimetorres.pruebades.dto.ResponseJson;
import net.jaimetorres.pruebades.services.CitaServices;

@RestController
@Api(value = "Consultar servicios relacionados con pacientes.",tags = "Servicios rest")
@RequestMapping("/pacientes/")	
public class PacientesRestController {

	@Autowired(required=true)
	CitaServices citaServices;
	
	@ApiOperation(value = "Listar medicamentos relacionados con el paciente")
	@PostMapping("consultaMedicamento")
	public ResponseJson consultarMedicamentos(@RequestBody PacienteDto paciente){
		return citaServices.consultarMedicamentos(paciente);
	}
	
	@ApiOperation(value = "Listar citas por dia y horar")
	@GetMapping("consultarCitas/{fecha}/{horaInicio}/{horaFin}")
	public ResponseJson consultarCitas(@PathVariable("fecha") String fecha,@PathVariable("horaInicio") 
	String horaInicio,@PathVariable("horaFin") String horaFin){
		return citaServices.consultarAgenda(fecha, horaInicio, horaFin);
	}
}

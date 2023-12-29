package net.jaimetorres.pruebades.controller;



import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@Validated
@RequestMapping("/pacientes/")	
public class PacientesRestController {

	@Autowired(required=true)
	CitaServices citaServices;
	
	@ApiOperation(value = "Listar medicamentos relacionados con el paciente",notes = "El metodo que consulta medicamentos por el id de pacientes.",response = ResponseJson.class)
	@PostMapping("consultaMedicamento")
	public ResponseJson consultarMedicamentos(@Valid @RequestBody PacienteDto paciente){
		return citaServices.consultarMedicamentos(paciente);
	}
	
	@ApiOperation(value = "Listar citas por dia y horar",notes = "El metodo que consulta agenda medica por dia y hora ",response = ResponseJson.class)
	@GetMapping("consultarCitas/{fecha}/{horaInicio}/{horaFin}")
	public ResponseJson consultarCitas(
		    @Pattern(regexp = ".{7,12}", message = "La longitud de la fecha debe estar entre 10 caracteres")
            @PathVariable("fecha")  String fecha,
			@Pattern(regexp = ".{6,10}", message = "La longitud de la hora debe ser 8")
		    @PathVariable("horaInicio") String horaInicio,
			@Pattern(regexp = ".{6,10}", message = "La longitud de la hora debe ser 8")
			@PathVariable("horaFin") String horaFin){
		return citaServices.consultarAgenda(fecha, horaInicio, horaFin);
	}
}

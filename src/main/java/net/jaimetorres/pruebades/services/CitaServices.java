package net.jaimetorres.pruebades.services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import net.jaimetorres.pruebades.entity.Medicamento;
import net.jaimetorres.pruebades.dto.CitaDto;
import net.jaimetorres.pruebades.dto.MedicamentoDto;
import net.jaimetorres.pruebades.dto.PacienteDto;
import net.jaimetorres.pruebades.dto.ResponseJson;
import net.jaimetorres.pruebades.repository.CitaRepository;


@Service
public class CitaServices {

	@Autowired(required=true)
	private CitaRepository citaRepository;
	
	/**
	 * Consultar medicamentos de un paciente
	 * @param paciente Objeto con datos del paciente
	 * @return Response (Status, Objeto y Mensaje)
	 */
	public ResponseJson consultarMedicamentos(PacienteDto paciente) {
		ModelMapper modelMapper=new ModelMapper();
		ResponseJson response=new ResponseJson();
		
		List<MedicamentoDto> medicamentosDto=new ArrayList<>();
		List<Medicamento> medicamentos=citaRepository.getMedicamentos(paciente.getNroIdentificacion());
		medicamentos.stream().forEach(m->{
			MedicamentoDto medicamento=modelMapper.map(m, MedicamentoDto.class);
			medicamentosDto.add(medicamento);
		});
		response.setObjeto(medicamentosDto);
		response.setStatus(HttpStatus.OK.value());
		response.setMensaje("Consulta Exitosa");
		return response;
	}
	/**
	 * Consultar agenda por dia y horas
	 * @param fecha fecha de consulta
	 * @param horaInicio hora Inicio
	 * @param horaFin hora Fin
	 * @return Response (Status, Objeto y Mensaje)
	 */
	public ResponseJson consultarAgenda(String fecha, String horaInicio, String horaFin) {
		ResponseJson response=new ResponseJson();
		try{
			Date fechaInicio=Date.valueOf(fecha);
			Time horaIni=Time.valueOf(horaInicio);
			Time horaFinal=Time.valueOf(horaFin);
			
			List<CitaDto> citas=citaRepository.getAgenda(fechaInicio, horaIni, horaFinal);		
			response.setObjeto(citas);
			response.setStatus(HttpStatus.OK.value());
			response.setMensaje("Consulta Exitosa");
				
		}catch(IllegalArgumentException e){
			response.setMensaje("Error en consulta");
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return response;
		
	}
}

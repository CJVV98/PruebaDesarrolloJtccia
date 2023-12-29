package net.jaimetorres.pruebades.repository;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.jaimetorres.pruebades.dto.CitaDto;
import net.jaimetorres.pruebades.entity.Cita;
import net.jaimetorres.pruebades.entity.Medicamento;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{
	
	
	@Query(value = "SELECT c.medicamentos FROM Cita c WHERE c.paciente.nroIdentificacion= :id ")
	public List<Medicamento> getMedicamentos(@Param("id") String nroIdentificacion);


	@Query(value = "SELECT new net.jaimetorres.pruebades.dto.CitaDto(c.paciente.nombre,c.paciente.apellido,c.fecha,c.hora) FROM Cita c WHERE c.fecha= :fecha AND c.hora BETWEEN :horaInicio AND :horaFin ")
	public List<CitaDto> getAgenda(@Param("fecha") Date fecha,@Param("horaInicio") Time horaInicio
			,@Param("horaFin") Time horaFin );

}
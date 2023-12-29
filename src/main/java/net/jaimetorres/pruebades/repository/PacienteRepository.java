package net.jaimetorres.pruebades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jaimetorres.pruebades.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}

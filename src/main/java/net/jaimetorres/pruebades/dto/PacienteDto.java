package net.jaimetorres.pruebades.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {
	
	private String nroIdentificacion;
	private String nombre;
	private String apellido;
}

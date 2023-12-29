package net.jaimetorres.pruebades.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

	@NotNull(message="El nro de identificacion es un campo requerido.")
	@Pattern(regexp = "[0-9]*",message = "El nro de identificacion  solo debe contener numeros.")
	@Size(min = 3,max = 11, message = "El nro de identificacion  debe contener entre 7 y 11 digitos.")
	@ApiModelProperty(notes = "Variable que contiene el nro de identificacion.", required = true, position = 0)
	private String nroIdentificacion;

	private String nombre;
	private String apellido;
}

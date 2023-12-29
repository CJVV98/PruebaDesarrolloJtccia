package net.jaimetorres.pruebades.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseJson {

	private int status;
	private String mensaje;
	private Object objeto;

}

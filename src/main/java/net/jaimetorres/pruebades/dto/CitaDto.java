package net.jaimetorres.pruebades.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitaDto {
   private String nombre;
   private String apellido;
   private Date fecha;
   private Date hora;
   
}

package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CandidatoCrearDto {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String titulo;
	private String descripcion;
	private String profileImage;
		
	public Candidato toCandidato()
	{
		return new Candidato(this.getId(), this.getNombre(), this.getApellido(),
				this.getDireccion(),this.getTitulo(),
				this.getDescripcion(), this.getProfileImage());
	}

}

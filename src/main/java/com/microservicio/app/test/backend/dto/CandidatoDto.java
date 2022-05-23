package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoDto {

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String titulo;
	private String descripcion;
	private String profileImage;
	
	public CandidatoDto(Candidato c) {
		
		this.id = c.getId();
		this.nombre = c.getNombre();
		this.apellido = c.getApellido();
		this.direccion = c.getDireccion();
		this.titulo = c.getTitulo();
		this.descripcion = c.getDescripcion();
		this.profileImage = c.getProfileImage();
	}

}

package com.microservicio.app.test.backend.dto;


import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.CandidatoExperiencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class CandidatoExperienciaDto {

	private Long id;
	private Candidato candidato;
	private String fechaDesde;
	private String fechaHasta;
	private String empresa;
	private String cargo;
	private String direccion;
	
	public CandidatoExperienciaDto(CandidatoExperiencia c)
	{
		this.id = c.getId();
		this.candidato = c.getCandidato();
		this.fechaDesde = c.getFechaDesde();
		this.fechaHasta = c.getFechaHasta();
		this.empresa = c.getEmpresa();
		this.cargo = c.getCargo();
		this.direccion = c.getDireccion();
	}

}

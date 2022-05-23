package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.CandidatoExperiencia;


import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CandidatoExperienciaCrearDto {

	private Long id;
	private Candidato candidato;
	private String fechaDesde;
	private String fechaHasta;
	private String empresa;
	private String cargo;
	private String direccion;
	
	public CandidatoExperiencia toCandidato()
	{
		return new CandidatoExperiencia(this.getId(), this.getCandidato(),this.getFechaDesde(), this.fechaHasta,
				this.getEmpresa(), this.getCargo(), this.getDireccion());
	}

}

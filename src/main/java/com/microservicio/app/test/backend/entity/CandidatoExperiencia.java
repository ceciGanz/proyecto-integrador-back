package com.microservicio.app.test.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "candidato_experiencia")
public class CandidatoExperiencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotNull(message = "el candidato no puede ser null")
	@OneToOne
	@JoinColumn(name = "candidato")
	private Candidato candidato;

	@NotNull(message = "la fecha desde no puede ser null")
	@Column(name = "fecha_desde")
	private String fechaDesde;

	@Column
	private String fechaHasta;

	private String empresa;
	private String cargo;
	private String direccion;

	public CandidatoExperiencia(Candidato candidato) {
	
		this.candidato = candidato;
	}


		

}

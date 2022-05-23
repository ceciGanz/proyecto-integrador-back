package com.microservicio.app.test.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "candidato")
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "el nombre no puede ser null")
	@Column(nullable = false)
	@Size(min = 4, message = "El nombre debe tener minimo 4 caracteres")
	private String nombre;
	
	@NotNull(message = "el nombre no puede ser null")
	@Column(nullable = false)
	@Size(min = 4, message = "El nombre debe tener minimo 4 caracteres")
	private String apellido;

	@Column
	private String direccion;


	@Column
	private String titulo;
    @Column( length = 8000)
	@Size(max = 8000)
	private String descripcion;

	@Column(name = "profile_image")
	private String profileImage;
	

}

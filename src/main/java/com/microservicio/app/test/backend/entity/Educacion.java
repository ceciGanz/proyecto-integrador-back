package com.microservicio.app.test.backend.entity;

import lombok.*;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "educacion")
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_universidad")
    private String nombreUniversidad;
    private String carrera;
    @Column(name = "fecha_desde")
    private String fechaDesde;
    @Column
    private String fechaHasta;

    @OneToOne
    @JoinColumn(name = "candidato")
    private Candidato candidato;

}

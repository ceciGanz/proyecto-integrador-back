package com.microservicio.app.test.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String titulo;
    @Column(length = 5000)
    @Size(max = 5000)
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "candidato")
    private Candidato candidato;

    @Column(name = "fecha_realizacion")
    private String fechaRealizacion;
}

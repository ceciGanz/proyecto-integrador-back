package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProyectoDto {

    private long id;
    private String titulo;
    private String descripcion;
    private Candidato candidato;
    private String fechaRealizacion;

    public ProyectoDto(Proyecto proyecto){
        this.id = proyecto.getId();
        this.titulo = proyecto.getTitulo();
        this.descripcion = proyecto.getDescripcion();
        this.candidato = proyecto.getCandidato();
        this.fechaRealizacion = proyecto.getFechaRealizacion();
    }
}

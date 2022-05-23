package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoCrearDto {

    private long id;
    private String titulo;
    private String descripcion;
    private Candidato candidato;
    private String fechaRealizacion;

    public Proyecto toProyecto(){

        return new Proyecto(this.getId(), this.getTitulo(), this.getDescripcion(), this.getCandidato(), this.fechaRealizacion);
    }
}

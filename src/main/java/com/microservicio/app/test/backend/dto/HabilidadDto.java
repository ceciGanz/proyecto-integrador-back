package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.Habilidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class HabilidadDto {

    private long id;
    private String nombre;
    private int progreso;
    private Candidato candidato;

    public HabilidadDto(Habilidad habilidad){

        this.id = habilidad.getId();
        this.nombre = habilidad.getNombre();
        this.progreso = habilidad.getProgreso();
        this.candidato = habilidad.getCandidato();
    }
}

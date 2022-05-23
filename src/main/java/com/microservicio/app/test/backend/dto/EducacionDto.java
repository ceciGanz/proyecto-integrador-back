package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.Educacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class EducacionDto {

    private long id;
    private String nombreUniversidad;
    private String carrera;
    private String fechaDesde;
    private String fechaHasta;
    private Candidato candidato;

    public EducacionDto (Educacion educacion) {

        this.id = educacion.getId();
        this.nombreUniversidad = educacion.getNombreUniversidad();
        this.carrera = educacion.getCarrera();
        this.fechaDesde = educacion.getFechaDesde();
        this.fechaHasta = educacion.getFechaHasta();
        this.candidato = educacion.getCandidato();
    }
}

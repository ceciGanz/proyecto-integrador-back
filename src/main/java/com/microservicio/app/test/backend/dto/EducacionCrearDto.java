package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.Educacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducacionCrearDto {

    private long id;
    private String nombreUniversidad;
    private String carrera;
    private String fechaDesde;
    private String fechaHasta;
    private Candidato candidato;

    public Educacion toEducacion(){

        return new Educacion(this.getId(), this.getNombreUniversidad(), this.getCarrera(), this.getFechaDesde(), this.getFechaHasta(),
                this.getCandidato());
    }


}

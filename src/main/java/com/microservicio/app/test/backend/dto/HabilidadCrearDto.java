package com.microservicio.app.test.backend.dto;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.Habilidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadCrearDto {

    private long id;
    private String nombre;
    private int progreso;
    private Candidato candidato;

    public Habilidad toHabilidad(){

        return new Habilidad(this.getId(), this.getNombre(), this.getProgreso(), this.getCandidato());
    }

}

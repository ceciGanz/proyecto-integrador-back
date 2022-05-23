package com.microservicio.app.test.backend.service;

import com.microservicio.app.test.backend.dto.HabilidadCrearDto;
import com.microservicio.app.test.backend.dto.HabilidadDto;
import com.microservicio.app.test.backend.entity.Habilidad;
import org.hibernate.validator.constraints.SafeHtml;

import java.util.List;

public interface HabilidadService {

    public List<HabilidadDto> listaHabilidad();
    public Habilidad buscarHabilidadId(long id);
    public HabilidadDto addHabilidad(HabilidadCrearDto habilidadCrearDto);
    public HabilidadDto updateHabilidad(long id, HabilidadCrearDto habilidadCrearDto);
    public void deletedHabilidad(long id);
}

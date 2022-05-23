package com.microservicio.app.test.backend.service;

import com.microservicio.app.test.backend.dto.EducacionCrearDto;
import com.microservicio.app.test.backend.dto.EducacionDto;
import com.microservicio.app.test.backend.entity.Educacion;

import java.util.List;

public interface EducacionService {

    public List<EducacionDto> listaEducion();
    public Educacion educacion(long id);
    public EducacionDto addEducacion(EducacionCrearDto educacionCrearDto);
    public EducacionDto updateEducacion(long id, EducacionCrearDto educacionCrearDto);
    public void deleteEducacion(long id);
}

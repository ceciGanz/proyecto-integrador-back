package com.microservicio.app.test.backend.service;

import com.microservicio.app.test.backend.dto.ProyectoCrearDto;
import com.microservicio.app.test.backend.dto.ProyectoDto;
import com.microservicio.app.test.backend.entity.Proyecto;

import java.util.List;

public interface ProyectoService {

    public List<ProyectoDto> listaProyecto();
    public Proyecto buscarProyecto(long id);
    public ProyectoDto addProyecto(ProyectoCrearDto proyectoCrearDto);
    public ProyectoDto updateProyecto(long id, ProyectoCrearDto proyectoCrearDto);
    public void eliminarProyecto(long id);
}

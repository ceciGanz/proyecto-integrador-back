package com.microservicio.app.test.backend.service;

import com.microservicio.app.test.backend.dto.EducacionDto;
import com.microservicio.app.test.backend.dto.ProyectoCrearDto;
import com.microservicio.app.test.backend.dto.ProyectoDto;
import com.microservicio.app.test.backend.entity.Educacion;
import com.microservicio.app.test.backend.entity.Proyecto;
import com.microservicio.app.test.backend.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<ProyectoDto> listaProyecto() {

        List<Proyecto> listaProyecto = proyectoRepository.findAll();

        return listaProyecto.stream().map(proyecto -> new ProyectoDto(proyecto.getId(),
                proyecto.getTitulo(), proyecto.getDescripcion(), proyecto.getCandidato(), proyecto.getFechaRealizacion()))
                .collect(Collectors.toList());

    }

    @Override
    public Proyecto buscarProyecto(long id) {

        Optional<Proyecto> proyecto = proyectoRepository.findById(id);

        if (!proyecto.isPresent()) {
            throw new NoSuchElementException("No existe el proyecto con el id: " + id);
        }

        return proyecto.get();
    }

    @Override
    public ProyectoDto addProyecto(ProyectoCrearDto proyectoCrearDto) {

        if (proyectoRepository.exists(Example.of(proyectoCrearDto.toProyecto()))) {
            throw new DuplicateKeyException(
                    "Ya existe el proyecto" + proyectoCrearDto.getTitulo() + " " + proyectoCrearDto.getDescripcion());
        }

        return new ProyectoDto(proyectoRepository.save(proyectoCrearDto.toProyecto()));

    }

    @Override
    public ProyectoDto updateProyecto(long id, ProyectoCrearDto proyectoCrearDto) {

        this.buscarProyecto(id);
        proyectoCrearDto.setId(id);
        return new ProyectoDto(proyectoRepository.save(proyectoCrearDto.toProyecto()));
    }

    @Override
    public void eliminarProyecto(long id) {

        this.buscarProyecto(id);
        proyectoRepository.deleteById(id);
    }
}

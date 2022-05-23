package com.microservicio.app.test.backend.service;

import com.microservicio.app.test.backend.dto.EducacionCrearDto;
import com.microservicio.app.test.backend.dto.EducacionDto;
import com.microservicio.app.test.backend.entity.Educacion;
import com.microservicio.app.test.backend.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EducacionServiceImpl implements EducacionService{

    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public List<EducacionDto> listaEducion() {

        List<Educacion> educacionLista = educacionRepository.findAll();

        return educacionLista.stream().map(educacion -> new EducacionDto(educacion.getId(), educacion.getNombreUniversidad(),
                educacion.getCarrera(), educacion.getFechaDesde(), educacion.getFechaHasta(), educacion.getCandidato())).collect(Collectors.toList());

    }

    @Override
    public Educacion educacion(long id) {

        Optional<Educacion> educacion = educacionRepository.findById(id);

        if (!educacion.isPresent()) {
            throw new NoSuchElementException("No existe la educacion con el id: " + id);
        }

        return educacion.get();
    }

    @Override
    public EducacionDto addEducacion(EducacionCrearDto educacionCrearDto) {

        if (educacionRepository.exists(Example.of(educacionCrearDto.toEducacion()))) {
            throw new DuplicateKeyException(
                    "Ya existe la universidad y carrera: " + educacionCrearDto.getNombreUniversidad() + " " + educacionCrearDto.getCarrera());
        }

        return new EducacionDto(educacionRepository.save(educacionCrearDto.toEducacion()));
    }

    @Override
    public EducacionDto updateEducacion(long id, EducacionCrearDto educacionCrearDto) {

        this.educacion(id);
        educacionCrearDto.setId(id);
        return new EducacionDto(educacionRepository.save(educacionCrearDto.toEducacion()));
    }

    @Override
    public void deleteEducacion(long id) {

        this.educacion(id);
        educacionRepository.deleteById(id);
    }
}

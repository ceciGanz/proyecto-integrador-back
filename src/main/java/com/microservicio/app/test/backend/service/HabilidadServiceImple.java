package com.microservicio.app.test.backend.service;

import com.microservicio.app.test.backend.dto.EducacionDto;
import com.microservicio.app.test.backend.dto.HabilidadCrearDto;
import com.microservicio.app.test.backend.dto.HabilidadDto;
import com.microservicio.app.test.backend.entity.Educacion;
import com.microservicio.app.test.backend.entity.Habilidad;
import com.microservicio.app.test.backend.repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HabilidadServiceImple implements HabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public List<HabilidadDto> listaHabilidad() {

        List<Habilidad> listaHabilidad = habilidadRepository.findAll();

        return listaHabilidad.stream()
                .map(habilidad -> new HabilidadDto(habilidad.getId(), habilidad.getNombre(), habilidad.getProgreso(),
                        habilidad.getCandidato()))
                .collect(Collectors.toList());
    }

    @Override
    public Habilidad buscarHabilidadId(long id) {

        Optional<Habilidad> habilidad = habilidadRepository.findById(id);

        if (!habilidad.isPresent()) {
            throw new NoSuchElementException("No existe la Habilidad con el id: " + id);
        }

        return habilidad.get();
    }

    @Override
    public HabilidadDto addHabilidad(HabilidadCrearDto habilidadCrearDto) {

        if (habilidadRepository.exists(Example.of(habilidadCrearDto.toHabilidad()))) {
            throw new DuplicateKeyException(
                    "Ya existe la habilidad: " + habilidadCrearDto.getNombre());
        }

        return new HabilidadDto(habilidadRepository.save(habilidadCrearDto.toHabilidad()));
    }

    @Override
    public HabilidadDto updateHabilidad(long id, HabilidadCrearDto habilidadCrearDto) {

        this.buscarHabilidadId(id);
        habilidadCrearDto.setId(id);
        return new HabilidadDto(habilidadRepository.save(habilidadCrearDto.toHabilidad()));

    }

    @Override
    public void deletedHabilidad(long id) {

        this.buscarHabilidadId(id);
        habilidadRepository.deleteById(id);
    }
}

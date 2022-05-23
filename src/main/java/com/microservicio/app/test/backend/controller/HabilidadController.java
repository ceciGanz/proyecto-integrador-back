package com.microservicio.app.test.backend.controller;

import com.microservicio.app.test.backend.dto.HabilidadCrearDto;
import com.microservicio.app.test.backend.dto.HabilidadDto;
import com.microservicio.app.test.backend.entity.Habilidad;
import com.microservicio.app.test.backend.exception.InvalidDataException;
import com.microservicio.app.test.backend.service.HabilidadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @GetMapping("/lista-habilidad")
    public ResponseEntity<List<HabilidadDto>> listaHabilidad(){

        return ResponseEntity.ok(habilidadService.listaHabilidad());
    }

    @GetMapping("/buscar-habilidad/{id}")
    public ResponseEntity<Habilidad> listaHabilidad(@PathVariable long id){

        return ResponseEntity.ok(habilidadService.buscarHabilidadId(id));
    }

    @PostMapping("/agregar-habilidad")
    public ResponseEntity<HabilidadDto> listaHabilidad(@Valid @RequestBody HabilidadCrearDto habilidadCrearDto,
                                                       BindingResult bindingResult ){

        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }

        log.info("Creando la habilidad " + habilidadCrearDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(habilidadService.addHabilidad(habilidadCrearDto));

    }

    @PutMapping("/modificar-habilidad/{id}")
    public ResponseEntity<HabilidadDto> listaHabilidad(@PathVariable long id, @Valid @RequestBody HabilidadCrearDto habilidadCrearDto,
                                                       BindingResult bindingResult ) {

        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }

        log.info("Actualizando la habilidad con id " + id);
        return ResponseEntity.ok(habilidadService.updateHabilidad(id, habilidadCrearDto));

    }

    @DeleteMapping("/educacion-habilidad/{id}")
    public ResponseEntity<?> eleiminarEducacion(@PathVariable long id){

        habilidadService.deletedHabilidad(id);

        log.info("Eliminar habilidad con id " + id);
        return ResponseEntity.ok().build();
    }

    }

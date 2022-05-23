package com.microservicio.app.test.backend.controller;

import com.microservicio.app.test.backend.dto.ProyectoCrearDto;
import com.microservicio.app.test.backend.dto.ProyectoDto;
import com.microservicio.app.test.backend.entity.Proyecto;
import com.microservicio.app.test.backend.exception.InvalidDataException;
import com.microservicio.app.test.backend.service.ProyectoService;
import lombok.extern.slf4j.Slf4j;
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
public class ProyectoController
{
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/lista-proyecto")
    public ResponseEntity<List<ProyectoDto>> listaProyecto(){

        return ResponseEntity.ok(proyectoService.listaProyecto());
    }

    @GetMapping("/buscar-proyecto/{id}")
    public ResponseEntity<Proyecto> buscarProyectoId(@PathVariable long id){

        return ResponseEntity.ok(proyectoService.buscarProyecto(id));
    }

    @PostMapping("/agregar-proyecto")
    public ResponseEntity<ProyectoDto> agregarProyecto(@Valid @RequestBody ProyectoCrearDto proyectoCrearDto, BindingResult bindingResult ){

        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }

        log.info("Creando proyecto" + proyectoCrearDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(proyectoService.addProyecto(proyectoCrearDto));

    }

    @PutMapping("/editar-proyecto/{id}")
    public ResponseEntity<ProyectoDto> modificarProyecto(@PathVariable long id,
                                                         @Valid
                                                         @RequestBody ProyectoCrearDto proyectoCrearDto,
                                                         BindingResult result){

        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }

        log.info("Actualizando el proyecto con id " + id);
        return ResponseEntity.ok(proyectoService.updateProyecto(id, proyectoCrearDto));
    }

    @DeleteMapping("/eliminar-proyecto/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable long id){

        proyectoService.eliminarProyecto(id);

        log.info("Eliminar proyecto con id " + id);
        return ResponseEntity.ok().build();
    }

}

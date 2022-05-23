package com.microservicio.app.test.backend.controller;

import com.microservicio.app.test.backend.dto.EducacionCrearDto;
import com.microservicio.app.test.backend.dto.EducacionDto;
import com.microservicio.app.test.backend.entity.Educacion;
import com.microservicio.app.test.backend.exception.InvalidDataException;
import com.microservicio.app.test.backend.service.EducacionService;
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
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @GetMapping("/lista-educacion")
    public ResponseEntity<List<EducacionDto>> listadoEducacion(){

        return ResponseEntity.ok(educacionService.listaEducion());
    }

    @GetMapping("/buscar-educacion/{id}")
    public ResponseEntity<Educacion> buscarEducacion(@PathVariable long id){

        return ResponseEntity.ok(educacionService.educacion(id));
    }

    @PostMapping("/agregar-educacion")
    public ResponseEntity<EducacionDto> agregarEducacion(@Valid @RequestBody EducacionCrearDto educacionCrearDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }

        log.info("Creando tecnologia " + educacionCrearDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(educacionService.addEducacion(educacionCrearDto));
    }

    @PutMapping("educacion-modificar/{id}")
    public ResponseEntity<EducacionDto> updateEducacion(@PathVariable long id,
                                                        @RequestBody EducacionCrearDto educacionCrearDto,
                                                        BindingResult result){

        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }

        log.info("Actualizando la educacion con id " + id);
        return ResponseEntity.ok(educacionService.updateEducacion(id, educacionCrearDto));

    }

    @DeleteMapping("educacion-eliminar/{id}")
    public ResponseEntity<?> eleiminarEducacion(@PathVariable long id){

        educacionService.deleteEducacion(id);

        log.info("Eliminar educacion con id " + id);
        return ResponseEntity.ok().build();
    }



}

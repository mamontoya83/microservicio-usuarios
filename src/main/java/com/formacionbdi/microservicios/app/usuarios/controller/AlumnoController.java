package com.formacionbdi.microservicios.app.usuarios.controller;

import com.formacionbdi.microservicios.app.usuarios.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AlumnoController {
    @Autowired
    private IAlumnoService IAlumnoService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(IAlumnoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<Alumno> o = IAlumnoService.findById(id);

        if(o.isEmpty())
            ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(o.get());
    }

}

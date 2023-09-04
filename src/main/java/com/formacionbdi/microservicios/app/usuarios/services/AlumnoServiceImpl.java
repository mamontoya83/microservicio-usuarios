package com.formacionbdi.microservicios.app.usuarios.services;

import com.formacionbdi.microservicios.app.usuarios.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepository IAlumnoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll() {
        return IAlumnoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id) {
        return IAlumnoRepository.findById(id);
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return IAlumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(Long id) {
        IAlumnoRepository.deleteById(id);
    }
}

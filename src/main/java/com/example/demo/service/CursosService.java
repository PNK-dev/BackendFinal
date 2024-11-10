package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cursos;

public interface CursosService {
	Cursos create(Cursos cursos);
	Cursos update(Cursos cursos);
    Optional<Cursos> read(Long id);
    void delete(Long id);
    List<Cursos> readAll();
}

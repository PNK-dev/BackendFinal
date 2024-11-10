package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Notas;

public interface NotasService {
	Notas create(Notas notas);
	Notas update(Notas notas);
    Optional<Notas> read(Long id);
    void delete(Long id);
    List<Notas> readAll();
}

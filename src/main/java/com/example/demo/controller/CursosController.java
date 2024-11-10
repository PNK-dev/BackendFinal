package com.example.demo.controller;

import com.example.demo.entity.Cursos;
import com.example.demo.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cursos")
@CrossOrigin(origins = "http://localhost:4200")
public class CursosController {
    
    @Autowired
    private CursosService cursosService;

    @GetMapping
    public ResponseEntity<List<Cursos>> readAll() {
        try {
            List<Cursos> cursos = cursosService.readAll();
            if (cursos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cursos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Cursos> crear(@Valid @RequestBody Cursos cursos) {
        try {
            Cursos c = cursosService.create(cursos);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> getCursosById(@PathVariable("id") Long id) {
        try {
            Optional<Cursos> c = cursosService.read(id);
            return c.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delCursos(@PathVariable("id") Long id) {
        try {
            cursosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursos> updateCursos(@PathVariable("id") Long id, @Valid @RequestBody Cursos cursos) {
        Optional<Cursos> existingCursos = cursosService.read(id);
        if (existingCursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(cursosService.update(cursos), HttpStatus.OK);
        }
    }
}

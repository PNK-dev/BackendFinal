package com.example.demo.controller;

import com.example.demo.entity.Notas;
import com.example.demo.service.NotasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/notas")
@CrossOrigin(origins = "http://localhost:4200")
public class NotasController {
    
    @Autowired
    private NotasService notasService;

    @GetMapping
    public ResponseEntity<List<Notas>> readAll() {
        try {
            List<Notas> notas = notasService.readAll();
            if (notas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(notas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Notas> crear(@Valid @RequestBody Notas notas) {
        try {
            Notas n = notasService.create(notas);
            return new ResponseEntity<>(n, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notas> getNotasById(@PathVariable("id") Long id) {
        try {
            Optional<Notas> n = notasService.read(id);
            return n.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delNotas(@PathVariable("id") Long id) {
        try {
            notasService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notas> updateNotas(@PathVariable("id") Long id, @Valid @RequestBody Notas notas) {
        Optional<Notas> existingNotas = notasService.read(id);
        if (existingNotas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(notasService.update(notas), HttpStatus.OK);
        }
    }
}

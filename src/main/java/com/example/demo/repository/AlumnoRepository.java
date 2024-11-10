package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Alumnos;

public interface AlumnoRepository extends JpaRepository<Alumnos, Long>{

}

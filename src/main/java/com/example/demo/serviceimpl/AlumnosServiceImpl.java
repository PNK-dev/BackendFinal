package com.example.demo.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumnos;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.service.AlumnosService;
@Service
public class AlumnosServiceImpl implements AlumnosService{
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public Alumnos create(Alumnos alumnos) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumnos);
	}

	@Override
	public Alumnos update(Alumnos alumnos) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumnos);
	}

	@Override
	public Optional<Alumnos> read(Long id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

	@Override
	public List<Alumnos> readAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

}

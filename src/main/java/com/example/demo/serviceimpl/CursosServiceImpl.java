package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cursos;
import com.example.demo.repository.CursosRepository;
import com.example.demo.service.CursosService;
@Service
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	private CursosRepository cursosRepository;

	@Override
	public Cursos create(Cursos cursos) {
		return cursosRepository.save(cursos);
	}

	@Override
	public Cursos update(Cursos cursos) {
		return cursosRepository.save(cursos);
	}

	@Override
	public Optional<Cursos> read(Long id) {
		return cursosRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		cursosRepository.deleteById(id);
	}

	@Override
	public List<Cursos> readAll() {
		return cursosRepository.findAll();
	}
}

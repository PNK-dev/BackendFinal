package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Notas;
import com.example.demo.repository.NotasRepository;
import com.example.demo.service.NotasService;
@Service
public class NotasServiceImpl implements NotasService {
	
	@Autowired
	private NotasRepository notasRepository;

	@Override
	public Notas create(Notas notas) {
		return notasRepository.save(notas);
	}

	@Override
	public Notas update(Notas notas) {
		return notasRepository.save(notas);
	}

	@Override
	public Optional<Notas> read(Long id) {
		return notasRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		notasRepository.deleteById(id);
	}

	@Override
	public List<Notas> readAll() {
		return notasRepository.findAll();
	}
}

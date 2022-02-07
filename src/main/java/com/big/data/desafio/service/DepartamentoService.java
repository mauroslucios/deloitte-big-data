package com.big.data.desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.big.data.desafio.dto.DepartamentoDTO;
import com.big.data.desafio.model.Departamento;
import com.big.data.desafio.repository.DepartamentoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartamentoService {
	
	private DepartamentoRepository departamentoRepository;

	public List<DepartamentoDTO> findAll() {
		List<Departamento> departamentos = departamentoRepository.findAll();
		return DepartamentoDTO.converter(departamentos);
	}

	public Departamento findOne(Long id) {
		return departamentoRepository.findById(id).get();
	}

	public Departamento inserirDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public void deletarDepartamentoById(Long id) {
		departamentoRepository.deleteById(id);
	}
	
	
	public Departamento updateDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	
	

}

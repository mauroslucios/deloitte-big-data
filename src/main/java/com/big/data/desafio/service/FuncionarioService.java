package com.big.data.desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.big.data.desafio.dto.FuncionarioDTO;
import com.big.data.desafio.model.Funcionario;
import com.big.data.desafio.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
	
	private FuncionarioRepository funcionarioRepository;

	public List<FuncionarioDTO> findAll() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return FuncionarioDTO.converter(funcionarios);
	}

}

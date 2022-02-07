package com.big.data.desafio.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.big.data.desafio.model.Departamento;

import lombok.Getter;

@Getter
public class DepartamentoDTO {

	private String nome;
	
	public DepartamentoDTO(Departamento departamento) {
		this.nome = departamento.getNome();
	}
	
	public static List<DepartamentoDTO> converter(List<Departamento> departamentos){
		return departamentos.stream().map(DepartamentoDTO::new).collect(Collectors.toList());
	}
}

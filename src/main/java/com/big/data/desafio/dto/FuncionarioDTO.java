package com.big.data.desafio.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.big.data.desafio.model.Departamento;
import com.big.data.desafio.model.Funcionario;

import lombok.Getter;
@Getter
public class FuncionarioDTO {

	private Departamento departamento;
	private String nome;
	private String cpf;
	private String email;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.departamento = funcionario.getDepartamento();
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.email = funcionario.getEmail();
	}
	
	public static List<FuncionarioDTO> converter(List<Funcionario> funcionarios){
		return funcionarios.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
	}
}

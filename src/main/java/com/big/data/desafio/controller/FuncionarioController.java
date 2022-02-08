package com.big.data.desafio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.big.data.desafio.dto.FuncionarioDTO;
import com.big.data.desafio.model.Funcionario;
import com.big.data.desafio.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api")
@Api(value="API Agência Cronos")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class FuncionarioController {

	private FuncionarioService funcionarioService;
	
	@GetMapping("/funcionarios")
	@ApiOperation(value="Retorna uma lista de funcionários")
	public List<FuncionarioDTO> listarFuncionarios(){
		return funcionarioService.findAll();
	}
	
	@GetMapping("/funcionarios/{id}")
	@ApiOperation(value="Busca um funcionario pleo id")
	public Funcionario findOne(@PathVariable (value="id") Long id) {
		return funcionarioService.findOne(id);
	}
	
	
	
	
	
	
	
	
	
	
}

package com.big.data.desafio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/funcionarios")
	@ApiOperation(value="Salva um funcionário no banco")
	public Funcionario insertFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.insertFuncionario(funcionario);
	}
	
	@DeleteMapping("/funcionarios/{id}")
	@ApiOperation(value="Deleta um produto pelo id")
	public void deleteProduto(@PathVariable Long id) {
		funcionarioService.deleteProduto(id);
	}
	
	
	
	
	
	
	
	
}

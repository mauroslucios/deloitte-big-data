package com.big.data.desafio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.big.data.desafio.dto.DepartamentoDTO;
import com.big.data.desafio.model.Departamento;
import com.big.data.desafio.service.DepartamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api")
@Api(value="API Agência Cronos")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class DepartamentoController {

	private DepartamentoService departamentoService;
	
	@GetMapping("/departamentos")
	@ApiOperation(value="Retorna uma lista de departamentos")
	public List<DepartamentoDTO> listarDepartamentos(){
		return departamentoService.findAll();
	}
	
	@GetMapping("/departamentos/{id}")
	@ApiOperation(value="Retorna um único departamento pelo id")
	public Departamento listarUnicoId(@PathVariable(value="id") Long id) {
		return departamentoService.findOne(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/departamentos")
	@ApiOperation(value="Salva um departamento no banco")
	public Departamento inserirDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.inserirDepartamento(departamento);
	}
	
	@DeleteMapping("/departamentos/{id}")
	@ApiOperation(value="Deleta um departamento pelo id")
	public void deletarDepartamento(@PathVariable Long id) {
		departamentoService.deletarDepartamentoById(id);
	}
	
	@PutMapping(value="/departamentos")
	@ApiOperation(value="Atualiza um departamento pelo id")
	public ResponseEntity<Departamento> updateDepartamento(@RequestBody Departamento departamento) {
		Departamento departamentoModificado = departamentoService.updateDepartamento(departamento);
		return new ResponseEntity<Departamento>(departamentoModificado, HttpStatus.OK);
	}
	
	
	
	
	
}

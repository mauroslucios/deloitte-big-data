package com.big.data.desafio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.big.data.desafio.dto.DepartamentoDTO;
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
	
}

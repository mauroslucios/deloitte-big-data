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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="API Agência Cronos")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class DepartamentoController {

	private DepartamentoService departamentoService;
	
	@ApiResponses( value= {
			@ApiResponse(code = 200, message = "Lista de departamentos encontrados"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Ocorreu uma exceção")
	})	
	@GetMapping("/listar/departamentos")
	@ApiOperation(value="Retorna uma lista de departamentos")
	public List<DepartamentoDTO> listarDepartamentos(){
		return departamentoService.findAll();
	}
	
	
	@ApiResponses( value= {
			@ApiResponse(code = 200, message = "Departamento encontrado com id informado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Ocorreu uma exceção")
	})
	@GetMapping("/listar/departamentos/{id}")
	@ApiOperation(value="Retorna um único departamento pelo id")
	public Departamento listarUnicoId(@PathVariable(value="id") Long id) {
		return departamentoService.findOne(id);
	}
	
	@ApiResponses( value= {
			@ApiResponse(code = 200, message = "Departamento cadastrado com sucesso!"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Ocorreu uma exceção")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/cadastrar/departamentos")
	@ApiOperation(value="Salva um departamento no banco")
	public Departamento inserirDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.inserirDepartamento(departamento);
	}
	
	@ApiResponses( value= {
			@ApiResponse(code = 200, message = "Deleta um departamento pelo id"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Ocorreu uma exceção")
	})
	@DeleteMapping("/deletar/departamentos/{id}")
	@ApiOperation(value="Deleta um departamento pelo id")
	public void deletarDepartamento(@PathVariable Long id) {
		departamentoService.deletarDepartamentoById(id);
	}
	
	@ApiResponses( value= {
			@ApiResponse(code = 200, message = "Departamento atualizado com sucesso!"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Ocorreu uma exceção")
	})
	@PutMapping(value="/alterar/departamentos/{id}")
	@ApiOperation(value="Atualiza um departamento pelo id")
	public ResponseEntity<DepartamentoDTO> atualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
		Departamento departamentoModificado = departamentoService.updateDepartamento(id,departamento);
		return ResponseEntity.ok().body(new DepartamentoDTO(departamentoModificado));
	}
	
	
	
	
	
}

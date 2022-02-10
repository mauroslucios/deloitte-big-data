package com.big.data.desafio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import com.big.data.desafio.dto.FuncionarioDTO;
import com.big.data.desafio.model.Funcionario;
import com.big.data.desafio.service.FuncionarioService;

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
public class FuncionarioController {

	private FuncionarioService funcionarioService;
	private final PasswordEncoder encoder;
	
	@GetMapping(value="/listar/funcionarios", produces = "application/json")
	@ApiOperation(value="Retorna uma lista de funcionários")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Funcionarios encontrados"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	public List<FuncionarioDTO> listarFuncionarios(){
		return funcionarioService.findAll();
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Funcionario encontrado pelo id"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	@GetMapping(value="/listar/funcionarios/{id}", produces = "application/json")
	@ApiOperation(value="Retorna um único funcionário pelo id")
	public ResponseEntity<FuncionarioDTO> listarFuncionariosPorId(@PathVariable (value="id") Long id) {
		FuncionarioDTO dto = new FuncionarioDTO(funcionarioService.listarFuncionariosPorId(id));
		return ResponseEntity.ok().body(dto);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Funcionario cadastrado com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="/cadastrar/funcionarios", produces="application/json")
	@ApiOperation(value="Cadastra um funcionário no banco")
	public Funcionario insertFuncionario(@RequestBody Funcionario funcionario) {
		funcionario.setSenha(encoder.encode(funcionario.getSenha()));
		return funcionarioService.insertFuncionario(funcionario);
	}
	
	@DeleteMapping(value="/deletar/funcionarios/{id}", produces= "application/json")
	@ApiOperation(value="Deleta um funcionário pelo id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Funcionário exluido com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Ocorreu uma exceção")
	})
	public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
		funcionarioService.deleteProduto(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Atualizar as informações de um funcionário")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Informações do funcionário alteradas com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Ocorreu uma exceção")
	})
	@PutMapping(value = "/alterar/funcionarios/{id}", produces = "application/json")
	public ResponseEntity<FuncionarioDTO> alterar(@PathVariable Long id, @RequestBody Funcionario funcionario){
		Funcionario detalhesFuncionario = funcionarioService.alterarFuncionario(id, funcionario);
		return ResponseEntity.ok().body(new FuncionarioDTO(detalhesFuncionario));
	}
	

}

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

import com.big.data.desafio.dto.PostDTO;
import com.big.data.desafio.model.Post;
import com.big.data.desafio.service.PostService;

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
public class PostController {

	private PostService postService;
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Posts encontrados"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	@GetMapping("/listar/posts")
	@ApiOperation(value="Retorna uma lista de posts")
	public List<PostDTO> listarPosts(){
		return postService.findAll();
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Retorna um único post pelo id"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	@GetMapping("/listar/posts/{id}")
	@ApiOperation(value="Busca um post pelo id")
	public Post findOne(@PathVariable(value="id") Long id) {
		return postService.findById(id);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Post cadastrado com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/cadastrar/posts")
	@ApiOperation(value="Salva um produto no banco")
	public Post insertPost(@RequestBody Post post) {
		return postService.insertPost(post);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Delat um post pelo id"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	@DeleteMapping("/deletar/posts/{id}")
	@ApiOperation(value="Deleta um post pelo id")
	public void deletePost(@PathVariable Long id) {
		postService.deletePostById(id);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Atualiza um post pelo id"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Aconteceu gerada uma exceção")
	})
	@PutMapping(value="/alterar/posts/{id}", produces = "application/json")
	public ResponseEntity<PostDTO> alterar(@PathVariable Long id, @RequestBody Post post){
		Post postAlterado = postService.updatePost(id, post);
		return ResponseEntity.ok().body(new PostDTO(postAlterado));
	}
	
}

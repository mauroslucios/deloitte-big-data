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

import com.big.data.desafio.dto.PostDTO;
import com.big.data.desafio.model.Post;
import com.big.data.desafio.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api")
@Api(value="API Agência Cronos")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class PostController {

	private PostService postService;
	
	@GetMapping("/posts")
	@ApiOperation(value="Retorna uma lista de posts")
	public List<PostDTO> listarPosts(){
		return postService.findAll();
	}
	
	@GetMapping("/posts/{id}")
	@ApiOperation(value="Busca um post pelo id")
	public Post findOne(@PathVariable(value="id") Long id) {
		return postService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/posts")
	@ApiOperation(value="Salva um produto no banco")
	public Post insertPost(@RequestBody Post post) {
		return postService.insertPost(post);
	}
	
	@DeleteMapping("/posts/{id}")
	@ApiOperation(value="Deleta um produto pelo id")
	public void deletePost(@PathVariable Long id) {
		postService.deletePostById(id);
	}
	
	
	
	
}

package com.big.data.desafio.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.big.data.desafio.model.Funcionario;
import com.big.data.desafio.model.Post;

import lombok.Getter;
@Getter
public class PostDTO {

	private String descricao;	
	private String titulo;
	private Funcionario funcionario;
	
	public PostDTO(Post post) {
		this.descricao = post.getDescricao();
		this.titulo = post.getTitulo();
		this.funcionario = post.getFuncionario();
	}
	
	public static List<PostDTO> converter(List<Post> posts){
		return posts.stream().map(PostDTO::new).collect(Collectors.toList());
	}
	
}

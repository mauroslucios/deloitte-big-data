package com.big.data.desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.big.data.desafio.dto.PostDTO;
import com.big.data.desafio.model.Post;
import com.big.data.desafio.repository.PostRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	
	private PostRepository postRepository;

	public List<PostDTO> findAll() {
		List<Post> posts = postRepository.findAll();
		return PostDTO.converter(posts);
	}

	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}

	public Post insertPost(Post post) {
		return postRepository.save(post);
	}

	public void deletePostById(Long id) {
		postRepository.deleteById(id);		
	}

	public Post updatePost(Long id, Post post) {
		Post postAtualizado = findById(id);
		postAtualizado.setDescricao(post.getDescricao());
		postAtualizado.setFuncionario(post.getFuncionario());
		postAtualizado.setTitulo(post.getTitulo());
		return postRepository.save(postAtualizado);
	}	
}

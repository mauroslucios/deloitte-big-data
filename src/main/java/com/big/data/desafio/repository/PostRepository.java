package com.big.data.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.big.data.desafio.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}

package com.corinto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corinto.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

package com.corinto.service;

import com.corinto.dto.PostDto;
import com.corinto.exception.PostNotFoundException;
import com.corinto.model.Post;
import com.corinto.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

   @Transactional
    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }

    @Transactional
    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Para o id " + id));
        return mapFromPostToDto(post);
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitlo(post.getTitlo());
        postDto.setConteudo(post.getConteudo());
        postDto.setNomeDoUsuario(post.getNomeDoUsuario());
        return postDto;
    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitlo(postDto.getTitlo());
        post.setConteudo(postDto.getConteudo());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("Nenhum usuário logado"));
        post.setCriadoEm(Instant.now());
        post.setNomeDoUsuario(loggedInUser.getUsername());
        post.setAtualizadoEm(Instant.now());
        return post;
    }
    
   
}

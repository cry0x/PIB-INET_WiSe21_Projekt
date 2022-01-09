package com.forum.backend.controllers;

import com.forum.backend.entities.Post;
import com.forum.backend.entities.PostDto;
import com.forum.backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/posts")

public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@ModelAttribute PostDto postDto) {
        return new ResponseEntity<>(this.postService.createPost(postDto.getPosts()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> readUserById(@PathVariable Long id) {
        return new ResponseEntity<>(this.postService.readPostById(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Iterable<Post>> getAllPosts() {
        return new ResponseEntity<>(this.postService.getAllPosts(), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePostById(@PathVariable Long id) {
        this.postService.deletePostById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
}
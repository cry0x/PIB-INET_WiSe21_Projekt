package com.forum.backend.services;

import com.forum.backend.entities.Post;
import com.forum.backend.excpetions.PostNotFoundException;
import com.forum.backend.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    public Post createPost(Post post) {
        return this.postRepository.save(post);
    }

    public Post readPostById(Long id) throws PostNotFoundException {
        return this.postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    public Iterable<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public void deletePostById(Long id) {
        this.postRepository.deleteById(id);
    }

    public Post findPostbyTitle(String title) {
        return this.postRepository.findPostbyTitle(title);
    }
}
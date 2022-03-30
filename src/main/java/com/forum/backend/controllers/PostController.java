package com.forum.backend.controllers;

import com.forum.backend.entities.Comment;
import com.forum.backend.entities.Post;
import com.forum.backend.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins="*")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        logger.info("POST /api/posts");

        return this.postService.createPost(post);
    }

    @GetMapping(value = "/{id}")
    public Post readUserById(@PathVariable Long id) {
        return this.postService.readPostById(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return this.postService.getAllPosts();
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Long id) {
        this.postService.deletePostById(id);
    }

    @PostMapping(path = "/{id}")
    public Post postCommentForPost(@PathVariable Long id, @RequestBody Comment comment) {
        logger.info(String.format("POST /api/posts/%s", id));

        return this.postService.addCommentToPost(id, comment);
    }
    
}

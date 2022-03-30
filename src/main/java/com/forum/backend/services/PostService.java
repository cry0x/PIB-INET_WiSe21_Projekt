package com.forum.backend.services;

import com.forum.backend.entities.Comment;
import com.forum.backend.entities.Post;
import com.forum.backend.excpetions.PostNotFoundException;
import com.forum.backend.repositories.CommentRepository;
import com.forum.backend.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ProfileService profileService;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository, ProfileService profileService) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.profileService = profileService;
    }
    
    public Post createPost(Post post) {
        return this.postRepository.save(post);
    }

    public Post readPostById(Long id) throws PostNotFoundException {
        return this.postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public void deletePostById(Long id) {
        this.postRepository.deleteById(id);
    }

    public Post addCommentToPost(Long id, Comment comment) {
        Post post = this.postRepository.findById(id).orElseThrow();
        comment.setPost(post);
        post.addComment(this.commentRepository.save(comment));
        return this.postRepository.save(post);
    }

}

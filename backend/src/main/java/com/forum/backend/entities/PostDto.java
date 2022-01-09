package com.forum.backend.entities;

import org.springframework.beans.factory.annotation.Configurable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Configurable
public class PostDto {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String post;

    public PostDto() {        
    }

    public Post getPosts() {
        Post post = new Post();

        post.setTitle(getTitle());
        post.setPost(getPost());
       
        return post;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
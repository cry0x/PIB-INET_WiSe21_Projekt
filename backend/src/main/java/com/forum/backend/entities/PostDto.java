package com.forum.backend.entities;

import org.springframework.beans.factory.annotation.Configurable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Configurable
public class PostDto {

    @NotNull
    @NotEmpty
    private String subject;

    @NotNull
    @NotEmpty
    private String user;

    

    public PostDto() {
        
    }
    
    public Post getPosts() {
        Post post = new Post();

        post.setSubject(getSubject());
        post.setUser(getUser());
       
        return post;
    }
    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    // public Object[] getComments() {
    //     return comments;
    // } 
// 
    // public void setComments(Object[]comments) {
    //     this.comments = comments;
    // }
}
package com.forum.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique=true)
    private String subject;
    private String user;
    private Object[]comments;


    public Post() {
        comments = new Object[50];
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Object[] getComments() {
        return comments;
    } 

    public void setComments(Object[]comments) {
        this.comments = comments;
    }
}
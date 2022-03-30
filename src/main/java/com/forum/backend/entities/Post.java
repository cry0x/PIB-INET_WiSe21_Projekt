package com.forum.backend.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String subject;
    private String username;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;

    public List<Comment> addComment(Comment comment) {
        this.commentList.add(comment);

        return this.commentList;
    }

}

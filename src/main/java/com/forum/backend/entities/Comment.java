package com.forum.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue
    private long id;
    private String content;
    @ManyToOne
    private User creator = new User();
}

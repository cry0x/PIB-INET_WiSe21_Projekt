package com.forum.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Post post;
    @OneToOne
    private User creator = new User();

}

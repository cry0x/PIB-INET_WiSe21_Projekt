package com.forum.backend.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String subject;
    private String name;
//    private Object[] comments = new Object[50];

}
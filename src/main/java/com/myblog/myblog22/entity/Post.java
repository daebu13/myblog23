package com.myblog.myblog22.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data //generates getters and setters
@Entity
@Table(name = "posts")
@AllArgsConstructor //constructors with args
@NoArgsConstructor // default constructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String title;

    private String description;

    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
}

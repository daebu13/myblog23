package com.myblog.myblog22.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

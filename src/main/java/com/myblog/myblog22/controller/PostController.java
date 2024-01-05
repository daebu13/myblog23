package com.myblog.myblog22.controller;

import com.myblog.myblog22.payload.PostDto;
import com.myblog.myblog22.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) { // constructor based dependency injection
        this.postService = postService;
    }

    @PostMapping //  for creating /submitting date to database
    /*@RequestBody is used for getting json object and storing in dto object here*/
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){ // dto is used to send the custom reposne back
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED); //CREATED gives 201 status
    }
}

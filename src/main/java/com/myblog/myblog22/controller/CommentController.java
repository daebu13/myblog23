package com.myblog.myblog22.controller;

import com.myblog.myblog22.payload.CommentDto;
import com.myblog.myblog22.service.CommentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //http:localhost:8083/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto> createComments(@RequestBody  CommentDto dto, @RequestParam long postId){
        CommentDto dtos = commentService.createPost(dto, postId);
        return  new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
}

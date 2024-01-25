package com.myblog.myblog22.controller;

import com.myblog.myblog22.entity.Post;
import com.myblog.myblog22.payload.PostDto;
import com.myblog.myblog22.service.PostService;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/posts")
public class PostController {

//    @PostMapping //  for creating /submitting data to database
//    /*@RequestBody is used for getting json object and storing in dto object here*/
//    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){ // dto is used to send the custom reposne back
//        PostDto dto = postService.createPost(postDto);
//        return new ResponseEntity<>(dto, HttpStatus.CREATED); //CREATED gives 201 status
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePost(@PathVariable long id){
//        postService.deletePost(id);
//    }

    private  PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping
    public  ResponseEntity<PostDto> createPosts(@RequestBody PostDto dto){
        PostDto createPost = postService.createPosts(dto);
        return  new ResponseEntity<>(createPost,HttpStatus.CREATED);
    }
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){

        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //http://localhost:8083/api/posts?pageNo=0&pageSize=3
    @GetMapping
    public List<PostDto> getAllPosts(@RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
                                     @RequestParam(name = "pageSize",defaultValue = "3",required = false)int pageSize,
                                     @RequestParam(name = "sortBy",defaultValue = "id",required = false)String sortBy,
                                     @RequestParam(name = "sortDir",defaultValue = "id",required = false)String sorDir){
        List<PostDto> dto = postService.getAllPosts(pageNo,pageSize,sortBy,sorDir);
        return  dto;
    }
}

package com.myblog.myblog22.service;

import com.myblog.myblog22.payload.PostDto;

import java.util.List;


public interface  PostService {
    PostDto createPosts(PostDto dto);

    PostDto getPostById(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize);
//    PostDto createPost(PostDto dto);
//
//    PostDto createPost(PostDto postDto);
//
//
//    void deletePost(long id);
}

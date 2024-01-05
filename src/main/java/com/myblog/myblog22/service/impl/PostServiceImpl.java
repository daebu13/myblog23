package com.myblog.myblog22.service.impl;

import com.myblog.myblog22.entity.Post;
import com.myblog.myblog22.payload.PostDto;
import com.myblog.myblog22.repository.PostRepository;
import com.myblog.myblog22.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;
    // instead of using Autowired we use construtor based dependency injection
    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepo.save(post); //got the saved details in post object (savedPost)
        // returning back
        PostDto dto = new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }
}

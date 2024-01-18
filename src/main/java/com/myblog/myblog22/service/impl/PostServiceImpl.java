package com.myblog.myblog22.service.impl;

import com.myblog.myblog22.entity.Post;
import com.myblog.myblog22.exception.ResourceNotFoundException;
import com.myblog.myblog22.payload.PostDto;
import com.myblog.myblog22.repository.PostRepository;
import com.myblog.myblog22.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;
    // instead of using Autowired we use construtor based dependency injection
    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPosts(PostDto dto) {

        Post post = mapToEntity(dto);
//        Post post = new Post();
//        post.setTitle(dto.getTitle());
//        post.setDescription(dto.getDescription());
//        post.setContent(dto.getContent());

        Post savedPost= postRepo.save(post);

        PostDto postDto = mapToDto(savedPost); // this function is the below code of taking data from post object to dto
        return  postDto;
        

//        PostDto postDto = new PostDto();
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());
//        return postDto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post Not found with id " +id)
        );
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize) {
        Pageable pageable=PageRequest.of(pageNo,pageSize);
        Page<Post> pagePost = postRepo.findAll(pageable);
        List<Post> posts = pagePost.getContent();  //here converting the pagePost into List of posts
        List<PostDto> dto = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dto;
    }
    
    
   PostDto mapToDto(Post post){
       PostDto postDto = new PostDto();
       postDto.setId(post.getId());
       postDto.setTitle(post.getTitle());
       postDto.setDescription(post.getDescription());
       postDto.setContent(post.getContent());
       return postDto;
   }
   
   Post mapToEntity(PostDto dto){
       Post post = new Post();
       post.setTitle(dto.getTitle());
       post.setDescription(dto.getDescription());
       post.setContent(dto.getContent());
       return post;
   }


//    @Override
//    public PostDto createPost(PostDto dto) {
//       Post post = new Post();
//       post.setTitle(dto.getTitle());
//       post.setDescription(post.getDescription());
//       post.setContent(dto.getContent());
//
//       postRepo.save(post);
//
//       PostDto postDto = new PostDto();
//
//       postDto.setTitle(post.getTitle());
//       postDto.setDescription(dto.getDescription());
//       postDto.setContent(dto.getContent());
//
//        return postDto;
//    }

//    @Override
//    public PostDto createPost(PostDto postDto) {
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
//        Post savedPost = postRepo.save(post); //got the saved details in post object (savedPost)
//        // returning back
//        PostDto dto = new PostDto();
//        dto.setTitle(savedPost.getTitle());
//        dto.setDescription(savedPost.getDescription());
//        dto.setContent(savedPost.getContent());
//        return dto;
//    }
//
//    @Override
//    public void deletePost(long id) {
//        postRepo.deleteById(id);
//    }





}

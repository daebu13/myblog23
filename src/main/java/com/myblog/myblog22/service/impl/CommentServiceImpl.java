package com.myblog.myblog22.service.impl;

import com.myblog.myblog22.entity.Comment;
import com.myblog.myblog22.entity.Post;
import com.myblog.myblog22.exception.ResourceNotFoundException;
import com.myblog.myblog22.payload.CommentDto;
import com.myblog.myblog22.repository.CommentRepository;
import com.myblog.myblog22.repository.PostRepository;
import com.myblog.myblog22.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper= modelMapper;
    }

    @Override
    public CommentDto createPost(CommentDto dto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found with id: " + postId)
        );
        Comment comment = new Comment(); // get the comment object from comment dto
        comment.setEmail(dto.getEmail());
        comment.setText(dto.getText());
        comment.setPost(post);  // comment for a particular post

        Comment savedComment = commentRepository.save(comment);

        CommentDto commentDto = new CommentDto();

        commentDto.setEmail(savedComment.getEmail());
        commentDto.setText(savedComment.getText());
        commentDto.setId(savedComment.getId());
        return commentDto;
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post not found for id " + id)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found for id " + id)
        );
        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment savedComment = commentRepository.save(c);
        CommentDto dto = mapToDto(savedComment);
        return dto;
        


    }

    public CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return  dto;
    }

    public Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return  comment;
    }
}

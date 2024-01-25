package com.myblog.myblog22.service.impl;

import com.myblog.myblog22.entity.Comment;
import com.myblog.myblog22.entity.Post;
import com.myblog.myblog22.exception.ResourceNotFoundException;
import com.myblog.myblog22.payload.CommentDto;
import com.myblog.myblog22.repository.CommentRepository;
import com.myblog.myblog22.repository.PostRepository;
import com.myblog.myblog22.service.CommentService;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
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
}

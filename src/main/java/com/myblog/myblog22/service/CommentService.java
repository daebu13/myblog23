package com.myblog.myblog22.service;

import com.myblog.myblog22.payload.CommentDto;

public interface CommentService {
    CommentDto createPost(CommentDto dto, long postId);

    void deleteById(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);
}

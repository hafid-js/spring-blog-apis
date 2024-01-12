package com.hafidtech.blog.services;

import com.hafidtech.blog.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}

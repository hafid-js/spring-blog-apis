package com.hafidtech.blog.controllers;

import com.hafidtech.blog.entities.Comment;
import com.hafidtech.blog.payloads.ApiResponse;
import com.hafidtech.blog.payloads.CommentDto;
import com.hafidtech.blog.services.CommentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping("/post/{postId}/comments")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto comment,
            @PathVariable Integer postId) {

        CommentDto createComment = this.commentService.createComment(comment, postId);
        return  new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);

    }


    @DeleteMapping("/comments/{commentId}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {

        this.commentService.deleteComment(commentId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !", true), HttpStatus.OK);
    }


}

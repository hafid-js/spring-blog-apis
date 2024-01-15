package com.hafidtech.blog.controllers;

import com.hafidtech.blog.config.AppConstants;
import com.hafidtech.blog.entities.Post;
import com.hafidtech.blog.payloads.ApiResponse;
import com.hafidtech.blog.payloads.PostDto;
import com.hafidtech.blog.payloads.PostResponse;
import com.hafidtech.blog.services.FIleService;
import com.hafidtech.blog.services.PostService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageReader;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FIleService fIleService;

    @Value("${project.image}")
    private String path;


    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) {

        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(
            @PathVariable Integer userId
    ) {
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(
            @PathVariable Integer categoryId
    ) {
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
    ) {
        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    @SecurityRequirement(name = "bearerAuth")
    public ApiResponse deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted !!", true);

    }

    @PutMapping("/posts/{postId}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
    }

    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(
            @PathVariable("keywords") String keywords

    ) {

        List<PostDto> result = this.postService.searchPosts(keywords);
        return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);

    }

    // post image upload

    @PostMapping("/post/image/upload/{postId}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<PostDto> uploadPostImage(
            @RequestParam("image")MultipartFile image,
            @PathVariable Integer postId
            ) throws IOException {

        String fileName = this.fIleService.uploadImage(path, image);
        PostDto postDto = this.postService.getPostById(postId);
        postDto.setImageName(fileName);
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
    }

    // method to serve files
    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {
        InputStream resource = this.fIleService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }
}

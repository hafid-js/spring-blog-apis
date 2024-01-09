package com.hafidtech.blog.services;

import com.hafidtech.blog.entities.Post;
import com.hafidtech.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<Post> getPostsByCategory(Integer categoryId);

    List<Post> getPostsByUser(Integer userId);

    List<Post> searchPosts(String keyword);
}

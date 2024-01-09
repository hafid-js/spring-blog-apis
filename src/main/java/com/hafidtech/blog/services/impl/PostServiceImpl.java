package com.hafidtech.blog.services.impl;

import com.hafidtech.blog.entities.Category;
import com.hafidtech.blog.entities.Post;
import com.hafidtech.blog.entities.User;
import com.hafidtech.blog.exceptions.ResourceNotFoundException;
import com.hafidtech.blog.payloads.PostDto;
import com.hafidtech.blog.repositories.CategoryRepo;
import com.hafidtech.blog.repositories.PostRepo;
import com.hafidtech.blog.repositories.UserRepo;
import com.hafidtech.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(() ->new ResourceNotFoundException("User", "user id", userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));


        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);


        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}

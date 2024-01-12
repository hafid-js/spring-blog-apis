package com.hafidtech.blog.repositories;

import com.hafidtech.blog.entities.Category;
import com.hafidtech.blog.entities.Post;
import com.hafidtech.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}

package com.hafidtech.blog.repositories;

import com.hafidtech.blog.entities.Category;
import com.hafidtech.blog.payloads.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


}

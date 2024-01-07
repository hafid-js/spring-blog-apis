package com.hafidtech.blog.repositories;

import com.hafidtech.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer> {


}

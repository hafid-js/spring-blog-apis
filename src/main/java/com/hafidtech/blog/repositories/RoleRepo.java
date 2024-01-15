package com.hafidtech.blog.repositories;

import com.hafidtech.blog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role, Integer> {

}
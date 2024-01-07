package com.hafidtech.blog.services;

import com.hafidtech.blog.entities.User;
import com.hafidtech.blog.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);


}

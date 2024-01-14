package com.hafidtech.blog.security;

import com.hafidtech.blog.entities.User;
import com.hafidtech.blog.exceptions.ResourceNotFoundException;
import com.hafidtech.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User ", "email : " + username, 0));
        return user;
    }
}

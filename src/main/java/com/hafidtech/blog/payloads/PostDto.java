package com.hafidtech.blog.payloads;

import com.hafidtech.blog.entities.Category;
import com.hafidtech.blog.entities.Comment;
import com.hafidtech.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {

    private Integer postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

    private Set<CommentDto> comments = new HashSet<>();

}

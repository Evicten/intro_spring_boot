package com.sec23.springboot.controllers;

import com.sec23.springboot.domain.DTO.UserDTO;
import com.sec23.springboot.domain.Post;
import com.sec23.springboot.domain.User;
import com.sec23.springboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/posts")
public class PostController {

    @Autowired
    private PostService service;


    @GetMapping(value="/{id}")
    public Post findById(@PathVariable String id){
        Post post = service.findById(id);
        return post;
    }

}

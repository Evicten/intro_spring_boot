package com.sec23.springboot.controllers;

import com.sec23.springboot.controllers.util.URL;
import com.sec23.springboot.domain.DTO.UserDTO;
import com.sec23.springboot.domain.Post;
import com.sec23.springboot.domain.User;
import com.sec23.springboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value="/titlesearch")
    public List<Post> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        return service.findByTitle(text);
    }

}

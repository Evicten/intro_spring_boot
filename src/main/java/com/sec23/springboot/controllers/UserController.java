package com.sec23.springboot.controllers;

import com.sec23.springboot.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @GetMapping
    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        list.add(new User("Ya", "ya", "ya"));
        return list;
    }
}

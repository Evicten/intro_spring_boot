package com.sec23.springboot.controllers;

import com.sec23.springboot.domain.DTO.UserDTO;
import com.sec23.springboot.domain.User;
import com.sec23.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDTO> findAll(){
        List<UserDTO> list = service.findAll();
        return list;
    }

    @GetMapping(value="/{id}")
    public UserDTO findById(@PathVariable String id){
        User user = service.findById(id);
        return new UserDTO(user);
    }

    @PostMapping
    public void insertUser(@RequestBody UserDTO usrdto){
        User usr = service.fromDTO(usrdto);
        usr = service.insert(usr);
    }
}

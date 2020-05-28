package com.sec23.springboot.services;

import com.sec23.springboot.DAO.UserRepository;
import com.sec23.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public List<User> findAll(){
        return userRepo.findAll();
    }
}

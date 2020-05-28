package com.sec23.springboot.services;

import com.sec23.springboot.DAO.UserRepository;
import com.sec23.springboot.domain.DTO.UserDTO;
import com.sec23.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public List<UserDTO> findAll(){
        return userRepo.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }
}

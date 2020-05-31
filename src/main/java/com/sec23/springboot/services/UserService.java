package com.sec23.springboot.services;

import com.sec23.springboot.DAO.UserRepository;
import com.sec23.springboot.domain.DTO.UserDTO;
import com.sec23.springboot.domain.User;
import com.sec23.springboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public List<UserDTO> findAll(){
        return userRepo.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public User findById(String id){
        Optional<User> user = userRepo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado"));
    }

    public User insert(User usr){
        return userRepo.insert(usr);
    }

    public User fromDTO(UserDTO usrdto){
        return new User(usrdto.getId(), usrdto.getName(), usrdto.getEmail());
    }

    public void deleteUser(String id){
        findById(id);
        userRepo.deleteById(id);
    }

    public User updateUser(User usr){
        User newUsr = userRepo.findById(usr.getId()).get();
        updateData(newUsr, usr);
        return userRepo.save(newUsr);
    }

    public void updateData(User usrPrv, User usrNxt){
        usrPrv.setName(usrNxt.getName());
        usrPrv.setEmail(usrNxt.getEmail());
    }
}

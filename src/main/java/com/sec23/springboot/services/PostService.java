package com.sec23.springboot.services;

import com.sec23.springboot.DAO.PostRepository;
import com.sec23.springboot.DAO.UserRepository;
import com.sec23.springboot.domain.DTO.UserDTO;
import com.sec23.springboot.domain.Post;
import com.sec23.springboot.domain.User;
import com.sec23.springboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post findById(String id){
        Optional<Post> post = postRepo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepo.findByTitleContaining(text);
    }

}

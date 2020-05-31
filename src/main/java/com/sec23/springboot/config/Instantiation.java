package com.sec23.springboot.config;

import com.sec23.springboot.DAO.PostRepository;
import com.sec23.springboot.DAO.UserRepository;
import com.sec23.springboot.domain.Post;
import com.sec23.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();
        User ya = new User(null, "yanew", "yo");
        userRepository.save(ya);

        Post post1 = new Post("123", "sdçaodjk", "sdjlad", "ajidjoa", ya);
        Post post2 = new Post("12r2343", "sdçaodjefwk", "sdfwefelad", "ajidjofwfwea", ya);
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}

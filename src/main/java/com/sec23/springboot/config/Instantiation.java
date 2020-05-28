package com.sec23.springboot.config;

import com.sec23.springboot.DAO.UserRepository;
import com.sec23.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User ya = new User(null, "yanew", "yo");
        userRepository.save(ya);
    }
}

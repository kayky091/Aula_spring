package com.example.aula_java.config;

import com.example.aula_java.model.User;
import com.example.aula_java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner run() {
        return args -> {
            User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
            User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
            userRepository.saveAll(Arrays.asList(u1, u2));
        };
    }
}


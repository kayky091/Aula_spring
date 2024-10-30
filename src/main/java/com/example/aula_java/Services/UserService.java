package com.example.aula_java.services;

import com.example.aula_java.model.User;
import com.example.aula_java.repositories.UserRepository;
import com.example.aula_java.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
    }

    public User update(Long id, User user) {
        User existingUser = findById(id);
        existingUser.setNome(user.getNome());
        existingUser.setEmail(user.getEmail());
        existingUser.setTelefone(user.getTelefone());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
}

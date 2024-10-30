package com.example.aula_java.repositories;

import com.example.aula_java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

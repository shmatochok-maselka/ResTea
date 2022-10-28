package com.example.restea.repository;

import com.example.restea.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String name);
}

package com.example.restea.service;

import com.example.restea.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    User findUserByName(String name);
    User findUserByEmail(String name);
    List<User> findAll();
    User createUser(User user);
}

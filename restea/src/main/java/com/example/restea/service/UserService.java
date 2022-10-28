package com.example.restea.service;

import com.example.restea.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> findAll();

    User createUser(User user);
}

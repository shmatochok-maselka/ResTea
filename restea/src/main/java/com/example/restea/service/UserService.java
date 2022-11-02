package com.example.restea.service;

import com.example.restea.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Long id);
    User findUserByName(String name);
    User findUserByEmail(String name);
    User saveUser(User user);
    void addRoleToUser(Long id, String roleName);
}

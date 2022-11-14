package com.example.restea.service;

import com.example.restea.dto.UserDataDto;
import com.example.restea.dto.UserDto;
import com.example.restea.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserById(Long id);

    User findUserByName(String name);

    User findUserByEmail(String name);

    User saveUser(User user);

    UserDto update(UserDataDto userDataDto, Principal principal);

    void addRoleToUser(Long id, String roleName);
}

package com.example.restea.service;

import com.example.restea.dto.UserCreateDto;
import com.example.restea.dto.UserUpdateDto;
import com.example.restea.dto.UserDto;
import com.example.restea.model.RoleEnum;

import java.security.Principal;
import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findUserById(Long id);
    UserDto findUserByName(String name);
    UserDto findUserByEmail(String name);
    UserDto saveUser(UserCreateDto user);
    UserDto update(UserUpdateDto userUpdateDto, Principal principal);
    void addRoleToUser(Long id, RoleEnum roleName);

}

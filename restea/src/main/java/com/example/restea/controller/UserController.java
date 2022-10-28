package com.example.restea.controller;

import com.example.restea.dto.UserDto;
import com.example.restea.model.User;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return new ResponseEntity<>(userService.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PostMapping
    public User saveUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto.toUser());
    }
}

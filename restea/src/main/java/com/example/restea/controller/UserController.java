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
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
        return new ResponseEntity<>(new UserDto(userService.findUserById(id)),
                HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<UserDto> findUserByName(@PathVariable String name) {
        return new ResponseEntity<>(new UserDto(userService.findUserByName(name)),
                HttpStatus.OK);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<UserDto> findUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(new UserDto(userService.findUserByEmail(email)),
                HttpStatus.OK);
    }


    @PostMapping
    public User saveUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto.toUser());
    }
}

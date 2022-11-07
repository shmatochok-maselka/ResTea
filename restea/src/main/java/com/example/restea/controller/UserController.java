package com.example.restea.controller;

import com.example.restea.dto.UserDto;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
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
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users").toUriString());
        return ResponseEntity.created(uri).body(new UserDto(userService.saveUser(userDto.toUser())));
    }
}

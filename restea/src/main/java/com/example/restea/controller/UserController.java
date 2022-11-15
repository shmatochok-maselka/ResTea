package com.example.restea.controller;

import com.example.restea.dto.UserCreateDto;
import com.example.restea.dto.UserDto;
import com.example.restea.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    /**
     * Method for creating an user.
     *
     * @return {@link UserDto} instance.
     * @author Oliyarnik Serhiy.
     */
    @Operation(summary = "Create new user")
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUser(userCreateDto));
    }


    /**
     * Method for finding user all user.
     *
     * @return {@link UserDto} instance.
     * @author Oliyarnik Serhiy.
     */
    @Operation(summary = "Get all users")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    /**
     * Method for finding user by id.
     *
     * @return {@link UserDto} instance.
     * @author Oliyarnik Serhiy.
     */
    @Operation(summary = "Find user by id")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    /**
     * Method for finding user by name.
     *
     * @return {@link UserDto} instance.
     * @author Oliyarnik Serhiy.
     */
    @Operation(summary = "Find user by name")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/findByName/{name}")
    public ResponseEntity<UserDto> findUserByName(@PathVariable String name) {
        return new ResponseEntity<>(userService.findUserByName(name), HttpStatus.OK);
    }

    /**
     * Method for finding user by email.
     *
     * @return {@link UserDto} instance.
     * @author Oliyarnik Serhiy.
     */
    @Operation(summary = "Find user by email")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<UserDto> findUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }

}

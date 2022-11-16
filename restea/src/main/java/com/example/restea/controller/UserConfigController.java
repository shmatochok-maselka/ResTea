package com.example.restea.controller;

import com.example.restea.dto.UserDataDto;
import com.example.restea.dto.UserDto;
import com.example.restea.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user/config")
public class UserConfigController {
    private final UserService userService;

    @Autowired
    public UserConfigController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Method for updating user.
     *
     * @return {@link UserDto} instance.
     * @author Oliyarnik Serhiy.
     */
    @Operation(summary = "Create new user")
    @PutMapping(value = "/update")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<UserDto> update(@RequestBody UserDataDto userDataDto, Principal principal) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.update(userDataDto, principal));
    }
}

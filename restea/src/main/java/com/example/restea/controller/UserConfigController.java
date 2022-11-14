package com.example.restea.controller;

import com.example.restea.dto.UserDataDto;
import com.example.restea.dto.UserDto;
import com.example.restea.service.UserService;
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

    @PutMapping(value = "/update")
    public ResponseEntity<UserDto> update(@RequestBody UserDataDto userDataDto, Principal principal) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.update(userDataDto, principal));
    }
}

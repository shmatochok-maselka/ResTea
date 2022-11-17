package com.example.restea.controller;

import com.example.restea.dto.UserUpdateDto;
import com.example.restea.dto.UserDto;
import com.example.restea.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/config")
public class UserConfigController {
    private final UserService userService;

    /**
     * Method for updating user.
     *
     * @return {@link UserDto} instance.
     * @author Oliyarnik Serhiy.
     */
    @Operation(summary = "Create new user")
    @PutMapping(value = "/update")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<UserDto> update(@RequestBody UserUpdateDto userUpdateDto, Principal principal) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.update(userUpdateDto, principal));
    }
}

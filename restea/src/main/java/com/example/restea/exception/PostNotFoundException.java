package com.example.restea.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PostNotFoundException extends ResponseStatusException {
    public PostNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }
}

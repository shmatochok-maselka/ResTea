package com.example.restea.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CartProductNotFoundException extends ResponseStatusException {
    public CartProductNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }
}

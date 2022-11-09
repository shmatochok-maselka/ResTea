package com.example.restea.controller;

import com.example.restea.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {
    @PostMapping(value = "/add_order")
    public ResponseEntity<Order> addOrder(@RequestBody Map<String, String> addOrderJSON) {
        if (addOrderJSON == null || !addOrderJSON.containsKey("userId") || !addOrderJSON.containsKey("receiverName")
                || !addOrderJSON.containsKey("receiverSecondName") || !addOrderJSON.containsKey("receiverSurname") ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
       
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package com.example.restea.controller;

import com.example.restea.dto.OrderDto;
import com.example.restea.dto.OrderProductDto;
import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import com.example.restea.service.OrderProductService;
import com.example.restea.service.OrderService;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {
    private OrderService orderService;

    private UserService userService;
    private OrderProductService orderProductService;

    @Autowired
    public OrderController(OrderService orderService, OrderProductService orderProductService, UserService userService) {
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.userService = userService;
    }

    @PostMapping(value = "/add_order")
    public ResponseEntity<Long> addOrder(@RequestBody OrderDto orderDto, Principal principal) {
//        try {
            Long userId = userService.findUserByEmail(principal.getName()).getId();
            orderDto.setUserId(userId);
            orderService.addOrder(orderDto.toOrder(), userId);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

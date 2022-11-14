package com.example.restea.controller;

import com.example.restea.dto.OrderDto;
import com.example.restea.service.CartService;
import com.example.restea.service.OrderProductService;
import com.example.restea.service.UserService;
import com.example.restea.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    private final UserService userService;
    private final OrderProductService orderProductService;

    private final CartService cartService;

    @Autowired
    public OrderController(OrderServiceImpl orderService, OrderProductService orderProductService, UserService userService,
                           CartService cartService) {
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostMapping(value = "/add_order")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDto orderDto, Principal principal) {
        try {
            Long userId = userService.findUserByEmail(principal.getName()).getId();
            orderService.addOrder(orderDto, userId, cartService);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

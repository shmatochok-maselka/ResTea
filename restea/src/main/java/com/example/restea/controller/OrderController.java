package com.example.restea.controller;

import com.example.restea.dto.OrderDto;
import com.example.restea.dto.UserDto;
import com.example.restea.model.*;
import com.example.restea.service.CartService;
import com.example.restea.service.OrderService;
import com.example.restea.service.ProductService;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {
    private OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add_order")
    public ResponseEntity<Order> addOrder(@RequestBody OrderDto orderDto) {
        try{
            orderService.addOrder(orderDto.toOrder());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//        Order order = orderDto.toOrder();
//        orderService.addOrder(orderDto.toOrder());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

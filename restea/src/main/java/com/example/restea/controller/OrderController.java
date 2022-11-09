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
import java.util.Map;
import java.util.NoSuchElementException;
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

    @PostMapping(value = "/add_order")
    public ResponseEntity<OrderDto> addOrder(@RequestBody Map<String, String> orderJSON) {
//        if (productCartJSON == null || !productCartJSON.containsKey("userId") || !productCartJSON.containsKey("productId")
//                || !productCartJSON.containsKey("productWeight")) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        Long productId = orderJSON.get("productId");
        OrderDto order = new OrderDto();
        order.setUserId(Long.parseLong(orderJSON.get("userId")));
        order.setReceiverName(orderJSON.get("receiverName"));
        order.setReceiverSecondName(orderJSON.get("receiverSecondName"));
        order.setReceiverSurname(orderJSON.get("receiverSurname"));
        order.setPhone(orderJSON.get("phone"));
        order.setAddress(orderJSON.get("address"));
        order.setOrderData(orderJSON.get("orderData"));
        order.setOrderPrice(Double.parseDouble(orderJSON.get("orderPrice")));
        orderService.addOrder(order.toOrder());
        return new ResponseEntity<>(HttpStatus.CREATED);
//        try{
//            orderService.addOrder(orderDto.toOrder());
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        Order order = orderDto.toOrder();
//        orderService.addOrder(orderDto.toOrder());
//  "orderData": "2022-10-09 17:18:25",
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/order/add_order").toUriString());
//        return ResponseEntity.created(uri).body(new OrderDto(orderService.addOrder(orderDto.toOrder())));
//                .saveUser(userDto.toUser())));
//        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

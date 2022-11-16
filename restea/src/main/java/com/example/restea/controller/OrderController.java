package com.example.restea.controller;

import com.example.restea.dto.OrderDto;
import com.example.restea.model.Order;
import com.example.restea.service.CartService;
import com.example.restea.service.UserService;
import com.example.restea.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    private final UserService userService;

    private final CartService cartService;

    @Autowired
    public OrderController(OrderServiceImpl orderService, UserService userService,
                           CartService cartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.cartService = cartService;
    }

    /**
     * Method for return all orders for user in the user page.
     *
     * @return {@link OrderDto} instance.
     * @author Iryna Kopchak.
     */
    @JsonIgnoreProperties({"receiverName", "receiverSecondName", "receiverSurname", "phone", "address"})
    @GetMapping
    public ResponseEntity<List<OrderDto>> findAllOrders(Principal principal) {
        Long userId = userService.findUserByIdPrincipal(principal);
        return new ResponseEntity<>(orderService.findAllUserOrders(userId), HttpStatus.OK);
    }

    /**
     * Method for add order for user.
     *
     * @return {@link OrderDto} instance.
     * @author Iryna Kopchak.
     */
    @PostMapping(value = "/add_order")
    public ResponseEntity<OrderDto> addOrder(@RequestBody Order order, Principal principal) {
        try {
            Long userId = userService.findUserByIdPrincipal(principal);
            orderService.addOrder(order, userId, cartService);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package com.example.restea.controller;

import com.example.restea.dto.OrderDto;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import com.example.restea.service.OrderProductService;
import com.example.restea.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {
    private OrderService orderService;
    private OrderProductService orderProductService;

    @Autowired
    public OrderController(OrderService orderService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @PostMapping(value = "/add_order")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
        try {
            orderService.addOrder(orderDto.toOrder());
            var orderProducts = orderDto.getOrderProducts();
            for (OrderProduct orderProduct: orderProducts){
                orderProduct.setId(new OrderProductId(orderDto.getId().longValue(), orderProduct.getId().getProductId()));
            }
            orderProductService.addAllProductsToOrder(orderProducts);
//            orderProductService.addProductToOrder();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

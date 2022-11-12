package com.example.restea.controller;

import com.example.restea.dto.OrderDto;
import com.example.restea.dto.OrderProductDto;
import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import com.example.restea.service.OrderProductService;
import com.example.restea.service.OrderService;
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
    private OrderProductService orderProductService;

    @Autowired
    public OrderController(OrderService orderService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @PostMapping(value = "/add_order")
    public ResponseEntity<Long> addOrder(@RequestBody OrderDto orderDto, Principal principal) {
        try {
            orderService.addOrder(orderDto.toOrder());
//            Long orderId = orderService.findByUserIdAndOrderData(orderDto.getUserId(), orderDto.getOrderData()).getId();
////            if(orderId == null){
////                throw new IllegalArgumentException();
////            }
////            List<OrderProductDto> orderProductsDto = orderDto.getOrderProducts();
////            List<OrderProduct> orderProducts = new ArrayList<>();
////            for (OrderProductDto orderProductDto: orderProductsDto){
////                OrderProduct orderProduct = new OrderProduct();
////                orderProduct.setId(new OrderProductId(orderId, orderProductDto.getProductId()));
////                orderProduct.setWeight(orderProductDto.getWeight());
////                orderProducts.add(orderProduct);
////                orderProductService.addProductToOrder(orderProduct);
////            }
////            orderProductService.addAllProductsToOrder(orderProducts);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderService.addOrder(orderDto.toOrder());
//        Long orderId = orderService.findByUserIdAndOrderData(orderDto.getUserId(), orderDto.getOrderData()).getId();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

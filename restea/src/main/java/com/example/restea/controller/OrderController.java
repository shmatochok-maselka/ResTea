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
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
        try {
            orderService.addOrder(orderDto.toOrder());
            Order order = orderService.findByUserIdAndOrderData(orderDto.getUserId(), orderDto.getOrderData());
            if(order == null){
                throw new IllegalArgumentException();
            }
//            if(orderDto.getId() == null){
//                throw new IllegalArgumentException();
//            }
//            var orderProductsDto = orderDto.getOrderProducts();
//            List<OrderProduct> orderProducts = new ArrayList<>();
//            for (OrderProductDto orderProductDto: orderProductsDto){
//                OrderProduct orderProduct = new OrderProduct();
//                orderProduct.setId(new OrderProductId(orderDto.getId().longValue(), orderProductDto.getProductId()));
////                orderProduct.setWeight(orderProductDto.getWeight());
//            }
//            orderProductService.addAllProductsToOrder(orderProducts);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

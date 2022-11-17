package com.example.restea.dto;

import com.example.restea.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String orderData;
    private double orderPrice;


    public OrderDto(Order order) {
        this.id = order.getId();
        this.orderData = order.getOrderData();
        this.orderPrice = order.getOrderPrice();
    }

    public Order toOrder() {
        Order order = new Order();
        order.setOrderData(this.orderData);
        order.setOrderPrice(this.orderPrice);
        return order;
    }
}

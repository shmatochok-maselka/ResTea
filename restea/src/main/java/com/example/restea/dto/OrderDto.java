package com.example.restea.dto;

import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.Product;
import com.example.restea.service.ProductFlavorService;
import com.example.restea.service.ProductPropertyService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Long id;

    private Long userId;

    private String receiverName;

    private String receiverSecondName;

    private String receiverSurname;

    private String phone;

    private String address;

    private LocalDateTime orderData;

    private int orderPrice;

    public void setOrderData(String dataTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dataTime, dateTimeFormatter);
        this.orderData = orderData;
    }

    public OrderDto(Order order){
        this.id = order.getId();
        this.userId = order.getUserId();
        this.receiverName = order.getReceiverName();
        this.receiverSecondName = order.getReceiverSecondName();
        this.receiverSurname = order.getReceiverSurname();
        this.phone = order.getPhone();
        this.address = order.getAddress();
        this.orderData = order.getOrderData();
        this.orderPrice = order.getOrderPrice();
    }

    public Order toOrder(){
        Order order = new Order();
        order.setUserId(this.userId);
        order.setReceiverName(this.receiverName);
        order.setReceiverSecondName(this.receiverSecondName);
        order.setReceiverSurname(this.receiverSurname);
        order.setPhone(this.phone);
        order.setAddress(this.address);
        order.setOrderData(this.orderData);
        order.setOrderPrice(this.orderPrice);
        return order;
    }
}

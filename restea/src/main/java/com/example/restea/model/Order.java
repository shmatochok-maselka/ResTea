package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "order")
@Getter
@Setter
@ToString
public class Order extends BaseEntity{
    @Column(name = "order_user_id")
    private Long userId;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_surname")
    private String receiverSurname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private LocalDateTime orderData;

    @Column(name = "price")
    private int orderPrice;
}

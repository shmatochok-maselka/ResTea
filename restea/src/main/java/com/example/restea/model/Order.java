package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_client")
@Getter
@Setter
@ToString
public class Order extends BaseEntity{
    @Column(name = "order_user_id")
    private Long userId;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_second_name")
    private String receiverSecondName;

    @Column(name = "receiver_surname")
    private String receiverSurname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "order_date")
    private LocalDateTime orderData;

    @Column(name = "price")
    private double orderPrice;

    @OneToMany(mappedBy="order")
    private List<OrderProduct> orderProducts;
}

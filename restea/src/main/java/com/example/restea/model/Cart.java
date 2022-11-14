package com.example.restea.model;

import com.example.restea.repository.UserRepository;
import com.example.restea.service.CartService;
import com.example.restea.service.ProductService;
import com.example.restea.service.UserService;
import com.example.restea.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cart")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart implements  java.io.Serializable{
    @EmbeddedId
    private CartId id;

    @Column(name = "weight")
    private int productWeight;

}

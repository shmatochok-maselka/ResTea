package com.example.restea.repository;

import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
}

package com.example.restea.repository;

import com.example.restea.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//public interface ProductRepository extends JpaRepository<Product, Long> {
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value = "SELECT min(price) FROM Product")
    public int min();

    @Query(value = "SELECT max(price) FROM Product")
    public int max();
}

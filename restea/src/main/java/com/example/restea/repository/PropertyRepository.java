package com.example.restea.repository;

import com.example.restea.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findByName(String name);
}

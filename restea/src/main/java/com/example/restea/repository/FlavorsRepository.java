package com.example.restea.repository;

import com.example.restea.model.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlavorsRepository extends JpaRepository<Flavor, Long> {
    Flavor findByName(String name);
}

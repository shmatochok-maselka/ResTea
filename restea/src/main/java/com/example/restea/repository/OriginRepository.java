package com.example.restea.repository;

import com.example.restea.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginRepository extends JpaRepository<Origin, Long> {
    Origin findByName(String name);
}

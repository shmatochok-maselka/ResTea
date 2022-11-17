package com.example.restea.service.impl;

import com.example.restea.dto.PropertyDto;
import com.example.restea.repository.PropertyRepository;
import com.example.restea.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<PropertyDto> findAllProductPropertiesDto() {
        return new ArrayList<>(propertyRepository.findAll().stream()
                .map(PropertyDto::new)
                .collect(Collectors.toList()));
    }
}

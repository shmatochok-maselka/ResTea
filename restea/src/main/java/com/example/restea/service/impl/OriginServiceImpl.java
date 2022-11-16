package com.example.restea.service.impl;

import com.example.restea.dto.ProductOriginDto;
import com.example.restea.repository.OriginRepository;
import com.example.restea.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OriginServiceImpl implements OriginService {
    private final OriginRepository originRepository;

    @Autowired
    public OriginServiceImpl(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    @Override
    public List<ProductOriginDto> findAllProductOrigin() {
        return new ArrayList<>(originRepository.findAll().stream()
                .map(ProductOriginDto::new)
                .collect(Collectors.toList()));
    }

}

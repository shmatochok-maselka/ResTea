package com.example.restea.service.impl;

import com.example.restea.dto.FlavorDto;
import com.example.restea.repository.FlavorsRepository;
import com.example.restea.service.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlavorServiceImpl implements FlavorService {
    private final FlavorsRepository flavorsRepository;

    @Autowired
    public FlavorServiceImpl(FlavorsRepository flavorsRepository) {
        this.flavorsRepository = flavorsRepository;
    }

    @Override
    public List<FlavorDto> findAllProductFlavorsDto() {
        return new ArrayList<>(flavorsRepository.findAll().stream()
                .map(FlavorDto::new)
                .collect(Collectors.toList()));
    }

}

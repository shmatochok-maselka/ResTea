package com.example.restea.service.impl;

import com.example.restea.dto.TypeDto;
import com.example.restea.repository.TypeRepository;
import com.example.restea.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<TypeDto> findAllProductType() {
        return new ArrayList<>(typeRepository.findAll().stream()
                .map(TypeDto::new)
                .collect(Collectors.toList()));
    }

}

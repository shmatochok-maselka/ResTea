package com.example.restea.controller;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductTypeDto;
import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Response {
    public Response(Set<ProductTypeDto> type, Set<ProductFlavorDto> flavor) {
        this.type = type;
        this.flavor = flavor;
    }

    private Set<ProductTypeDto> type;
    private Set<ProductFlavorDto> flavor;
}

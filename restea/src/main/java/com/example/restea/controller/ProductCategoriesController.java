package com.example.restea.controller;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductTypeDto;
import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductType;
import com.example.restea.service.ProductFlavorService;
import com.example.restea.service.ProductOriginService;
import com.example.restea.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v1/categories")
public class ProductCategoriesController {
    private ProductTypeService productTypeService;
    private ProductOriginService productOriginService;
    private ProductFlavorService productFlavorService;

    @Autowired
    public ProductCategoriesController(ProductTypeService productTypeService, ProductOriginService productOriginService,
                                       ProductFlavorService productFlavorService) {
        this.productTypeService = productTypeService;
        this.productOriginService = productOriginService;
        this.productFlavorService = productFlavorService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Response> findAllProducts() {
//        Map<String, Object> map= new HashMap<>();
        Set<ProductType> var1 = productTypeService.findAll();
        Set<ProductFlavor> var2 = productFlavorService.findAll();
        Response result = new Response(typeDtoSet(var1), flavorsDtoSet(var2));
//        map.put("type", productTypeService.findAll());
        //System.out.println(map.toString());
//        map.put("origin", productTypeService.findAll());
        //System.out.println(map.toString());
        return ResponseEntity.ok(result);
//                .map(ProductDto::new)
//                .collect(Collectors.toList()),
//                HttpStatus.OK);
    }
    public Set<ProductTypeDto> typeDtoSet(Set<ProductType> productTypes){
        Set<ProductTypeDto> typeDtos = new HashSet<>();
        for (ProductType productType : productTypes){
            var flavorDto = new ProductTypeDto();
            flavorDto.setId(productType.getId());
            flavorDto.setName(productType.getName());
            typeDtos.add(flavorDto);
        }
        return typeDtos;
    }

    public Set<ProductFlavorDto> flavorsDtoSet(Set<ProductFlavor> productFlavors){
        Set<ProductFlavorDto> flavorsDto = new HashSet<ProductFlavorDto>();
        for (ProductFlavor productFlavor : productFlavors){
            var flavorDto = new ProductFlavorDto();
            flavorDto.setId(productFlavor.getId());
            flavorDto.setName(productFlavor.getName());
            flavorsDto.add(flavorDto);
        }
        return flavorsDto;
    }
}

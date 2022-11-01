package com.example.restea.controller;

import com.example.restea.dto.ProductFlavorDto;
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
        Set<ProductType> var1 = productTypeService.findAll();
        Set<ProductFlavor> var2 = productFlavorService.findAll();
        Response result = new Response(productTypeService.typeSetToTypeDtoSet(var1),
                productFlavorService.flavorSetToFlavorDtoSet(var2));
        return ResponseEntity.ok(result);
    }
}

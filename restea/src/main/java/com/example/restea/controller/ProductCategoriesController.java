package com.example.restea.controller;

import com.example.restea.model.ProductCategories;
import com.example.restea.model.ProductProperty;
import com.example.restea.service.ProductFlavorService;
import com.example.restea.service.ProductOriginService;
import com.example.restea.service.ProductPropertyService;
import com.example.restea.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class ProductCategoriesController {
    private ProductTypeService productTypeService;
    private ProductOriginService productOriginService;
    private ProductFlavorService productFlavorService;
    private ProductPropertyService productPropertyService;

    @Autowired
    public ProductCategoriesController(ProductTypeService productTypeService, ProductOriginService productOriginService,
                                       ProductFlavorService productFlavorService,
                                       ProductPropertyService productPropertyService) {
        this.productTypeService = productTypeService;
        this.productOriginService = productOriginService;
        this.productFlavorService = productFlavorService;
        this.productPropertyService = productPropertyService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<ProductCategories> findAllCategories() {
        ProductCategories productCategories = new ProductCategories(productTypeService.typeSetToTypeDtoSet(productTypeService.findAll()),
                productFlavorService.flavorSetToFlavorDtoSet(productFlavorService.findAll()),
                productOriginService.originSetToOriginDtoSet(productOriginService.findAll()),
                productPropertyService.propertySetToPropertyDtoSet(productPropertyService.findAll()));
        return ResponseEntity.ok(productCategories);
    }
}

package com.example.restea.controller;

import com.example.restea.model.ProductCategories;
import com.example.restea.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/categories")
public class ProductCategoriesController {
    private ProductTypeService productTypeService;
    private ProductOriginService productOriginService;
    private ProductFlavorService productFlavorService;
    private ProductPropertyService productPropertyService;
    private ProductService productService;

    @Autowired
    public ProductCategoriesController(ProductTypeService productTypeService, ProductOriginService productOriginService,
                                       ProductFlavorService productFlavorService,
                                       ProductPropertyService productPropertyService, ProductService productService) {
        this.productTypeService = productTypeService;
        this.productOriginService = productOriginService;
        this.productFlavorService = productFlavorService;
        this.productPropertyService = productPropertyService;
        this.productService = productService;
    }
    @GetMapping("/max_min_price")
    @ResponseBody
    public ResponseEntity<Object> maxAndMinPricesOfProduct() {
        JSONObject minMaxPriceJsonObject = new JSONObject();
        minMaxPriceJsonObject.put("min", productService.minProductPrice());
        minMaxPriceJsonObject.put("max", productService.maxProductPrice());
        JSONArray response = new JSONArray();
        response.put(minMaxPriceJsonObject.toMap());
        return new ResponseEntity<>(minMaxPriceJsonObject.toMap(), HttpStatus.OK);
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<ProductCategories> findAllCategories() {
        ProductCategories productCategories = new ProductCategories
                (productTypeService.typeSetToTypeDtoSet(productTypeService.findAll()),
                productFlavorService.flavorSetToFlavorDtoSet(productFlavorService.findAll()),
                productOriginService.originSetToOriginDtoSet(productOriginService.findAll()),
                productPropertyService.propertySetToPropertyDtoSet(productPropertyService.findAll()));
        return ResponseEntity.ok(productCategories);
    }
}

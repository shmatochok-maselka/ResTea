package com.example.restea.controller;

import com.example.restea.dto.ProductCategoriesDto;
import com.example.restea.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/categories")
public class ProductCategoriesController {
    private final TypeService typeService;
    private final OriginService originService;
    private final FlavorService flavorService;
    private final PropertyService propertyService;
    private final ProductService productService;

    @Autowired
    public ProductCategoriesController(TypeService typeService, OriginService originService,
                                       FlavorService flavorService,
                                       PropertyService propertyService, ProductService productService) {
        this.typeService = typeService;
        this.originService = originService;
        this.flavorService = flavorService;
        this.propertyService = propertyService;
        this.productService = productService;
    }

    /**
     * Method for return min and max price for filter in shop page.
     *
     * @author Iryna Kopchak.
     */
    @GetMapping("/max_min_price")
    @ResponseBody
    public ResponseEntity<Object> maxAndMinPricesOfProduct() {
        return new ResponseEntity<>(productService.minMaxProductPrice().toMap(), HttpStatus.OK);
    }

    /**
     * Method for return all categories of products for filter in shop page.
     *
     * @return {@link ProductCategoriesDto} instance.
     * @author Iryna Kopchak.
     */
    @GetMapping()
    @ResponseBody
    public ResponseEntity<ProductCategoriesDto> findAllCategories() {
        ProductCategoriesDto productCategoriesDto = new ProductCategoriesDto
                (typeService.findAllProductType(), flavorService.findAllProductFlavorsDto(),
                        originService.findAllProductOrigin(), propertyService.findAllProductPropertiesDto());
        return ResponseEntity.ok(productCategoriesDto);
    }
}

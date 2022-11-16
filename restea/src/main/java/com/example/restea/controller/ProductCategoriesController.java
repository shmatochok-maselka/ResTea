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
    private final ProductTypeService productTypeService;
    private final ProductOriginService productOriginService;
    private final ProductFlavorService productFlavorService;
    private final ProductPropertyService productPropertyService;
    private final ProductService productService;

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
                (productTypeService.findAllProductType(), productFlavorService.findAllProductFlavorsDto(),
                        productOriginService.findAllProductOrigin(), productPropertyService.findAllProductPropertiesDto());
        return ResponseEntity.ok(productCategoriesDto);
    }
}

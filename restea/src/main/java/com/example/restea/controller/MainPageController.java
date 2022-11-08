package com.example.restea.controller;

import com.example.restea.dto.MainPageDto;
import com.example.restea.model.ProductCategories;
import com.example.restea.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/main_page")
public class MainPageController {

    private ProductService productService;
    private BlogPostService blogPostService;

    @Autowired
    public MainPageController(ProductService productService, BlogPostService blogPostService) {
        this.productService = productService;
        this.blogPostService = blogPostService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<MainPageDto> findAllData() {
        MainPageDto mainPageDto = new MainPageDto(productService, blogPostService);
        return ResponseEntity.ok(mainPageDto);
    }
}

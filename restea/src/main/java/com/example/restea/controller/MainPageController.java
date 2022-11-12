package com.example.restea.controller;

import com.example.restea.dto.MainPageDto;
import com.example.restea.service.BlogPostService;
import com.example.restea.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/main_page")
public class MainPageController {

    private final ProductService productService;
    private final BlogPostService blogPostService;

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

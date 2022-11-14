package com.example.restea.dto;

import com.example.restea.model.BlogPost;
import com.example.restea.model.Product;
import com.example.restea.service.BlogPostService;
import com.example.restea.service.ProductFlavorService;
import com.example.restea.service.ProductPropertyService;
import com.example.restea.service.ProductService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MainPageDto {
    private List<Product> products;
    private List<BlogPost> blogPosts;

    public MainPageDto(ProductService productService, BlogPostService blogPostService) {
        this.products = productService.getProductsForMainPage();
        this.blogPosts = blogPostService.getPostsForMainPage();
    }
}

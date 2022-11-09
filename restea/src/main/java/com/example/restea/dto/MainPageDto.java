package com.example.restea.dto;

import com.example.restea.model.BlogPost;
import com.example.restea.service.BlogPostService;
import com.example.restea.service.ProductService;
import com.example.restea.service.impl.ProductServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MainPageDto {

    private List<MainPageProductDto> products;

    private List<BlogPostDto> blogPosts;

    public MainPageDto(ProductService productService, BlogPostService blogPostService) {
        this.products = productService.getProductsForMainPage();
        this.blogPosts = blogPostService.getPostsForMainPage();
    }
}

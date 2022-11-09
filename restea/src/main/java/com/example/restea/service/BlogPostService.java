package com.example.restea.service;

import com.example.restea.dto.BlogPostDto;
import com.example.restea.dto.ProductDto;
import com.example.restea.model.BlogPost;
import com.example.restea.model.ProductType;

import java.util.List;
import java.util.Set;

public interface BlogPostService {
    BlogPost findPostById(Long id);
    List<BlogPost> findAll();

    List<BlogPostDto> getPostsForMainPage();
}

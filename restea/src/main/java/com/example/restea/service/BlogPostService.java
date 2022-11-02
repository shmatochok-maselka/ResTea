package com.example.restea.service;

import com.example.restea.model.BlogPost;
import com.example.restea.model.ProductType;

import java.util.Set;

public interface BlogPostService {
    BlogPost findPostById(Long id);
    Set<BlogPost> findAll();
}

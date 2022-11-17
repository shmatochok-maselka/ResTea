package com.example.restea.service;

import com.example.restea.dto.BlogPostDto;

import java.util.List;

public interface BlogPostService {
    BlogPostDto findPostById(Long id);

    List<BlogPostDto> findAll();

    List<BlogPostDto> getPostsForMainPage();
}

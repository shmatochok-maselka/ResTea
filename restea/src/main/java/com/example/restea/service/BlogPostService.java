package com.example.restea.service;

import com.example.restea.model.BlogPost;

import java.util.List;

public interface BlogPostService {
    BlogPost findPostById(Long id);
    List<BlogPost> findAll();
    List<BlogPost> getPostsForMainPage();
}

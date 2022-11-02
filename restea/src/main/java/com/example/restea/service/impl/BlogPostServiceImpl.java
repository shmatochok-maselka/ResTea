package com.example.restea.service.impl;

import com.example.restea.model.BlogPost;
import com.example.restea.repository.BlogPostRepository;
import com.example.restea.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
    @Override
    public BlogPost findPostById(Long id) {
        return blogPostRepository.findById(id).get();
    }

    @Override
    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }
}

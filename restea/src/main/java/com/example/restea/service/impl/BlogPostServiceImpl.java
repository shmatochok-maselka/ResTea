package com.example.restea.service.impl;

import com.example.restea.dto.BlogPostDto;
import com.example.restea.exception.PostNotFoundException;
import com.example.restea.exception.UserNotFoundException;
import com.example.restea.repository.BlogPostRepository;
import com.example.restea.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
    @Override
    public BlogPostDto findPostById(Long id) {
        return new BlogPostDto(blogPostRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(HttpStatus.NOT_FOUND, "No post with such id")));
    }

    @Override
    public List<BlogPostDto> findAll() {
        return blogPostRepository.findAll().stream()
                .map(BlogPostDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<BlogPostDto> getPostsForMainPage() {
        return this.findAll().stream().limit(3).collect(Collectors.toList());
    }
}

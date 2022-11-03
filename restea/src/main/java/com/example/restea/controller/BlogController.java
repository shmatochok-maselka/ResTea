package com.example.restea.controller;

import com.example.restea.dto.BlogPostDto;
import com.example.restea.dto.ProductDto;
import com.example.restea.model.BlogPost;
import com.example.restea.model.Product;
import com.example.restea.service.BlogPostService;
import com.example.restea.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/blog")
public class BlogController {
    private BlogPostService blogPostService;

    @Autowired
    public BlogController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
    @GetMapping
    public ResponseEntity<List<BlogPostDto>> findAllProducts() {
        return new ResponseEntity<>(blogPostService.findAll().stream()
                .map(BlogPostDto::new)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BlogPostDto> findProductById(@PathVariable Long postId) {
        if(postId == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            BlogPost blogPost = blogPostService.findPostById(postId);
        } catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new BlogPostDto(blogPostService.findPostById(postId)),
                HttpStatus.OK);
    }
}

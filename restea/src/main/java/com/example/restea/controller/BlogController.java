package com.example.restea.controller;

import com.example.restea.model.BlogPost;
import com.example.restea.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/blog")
public class BlogController {
    private final BlogPostService blogPostService;

    @Autowired
    public BlogController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> findAllPosts() {
//        return new ResponseEntity<>(blogPostService.findAll().stream()
//                .map(BlogPostDto::new)
//                .collect(Collectors.toList()),
//                HttpStatus.OK);
        return new ResponseEntity<>(blogPostService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BlogPost> findPostById(@PathVariable Long postId) {
        if(postId == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            blogPostService.findPostById(postId);
        } catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPostService.findPostById(postId),
                HttpStatus.OK);
    }
}

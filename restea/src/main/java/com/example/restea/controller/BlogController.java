package com.example.restea.controller;

import com.example.restea.dto.BlogPostDto;
import com.example.restea.dto.UserDto;
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

    /**
     * Method for return all posts.
     *
     * @return {@link BlogPostDto} instance.
     * @author Iryna Kopchak.
     */
    @GetMapping
    public ResponseEntity<List<BlogPostDto>> findAllPosts() {
        return new ResponseEntity<>(blogPostService.findAll(), HttpStatus.OK);
    }

    /**
     * Method for return particular post by id.
     *
     * @return {@link BlogPostDto} instance.
     * @author Iryna Kopchak.
     */
    @GetMapping("/{postId}")
    public ResponseEntity<BlogPostDto> findPostById(@PathVariable Long postId) {
        try{
            blogPostService.findPostById(postId);
        } catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPostService.findPostById(postId),
                HttpStatus.OK);
    }
}

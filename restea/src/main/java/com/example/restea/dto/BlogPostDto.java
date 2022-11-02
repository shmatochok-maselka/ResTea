package com.example.restea.dto;

import com.example.restea.model.BlogPost;
import com.example.restea.model.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogPostDto {
    private Long id;
    private String title;
    private String content;

    public BlogPostDto(BlogPost blogPost) {
        this.id = blogPost.getId();
        this.title = blogPost.getTitle();
        this.content = blogPost.getContent();
    }

    public BlogPost toBlogPost(){
        BlogPost blogPost = new BlogPost();
        blogPost.setId(this.id);
        blogPost.setTitle(this.title);
        blogPost.setContent(this.content);
        return blogPost;
    }
}

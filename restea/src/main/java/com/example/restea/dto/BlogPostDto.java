package com.example.restea.dto;

import com.example.restea.model.BlogPost;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogPostDto {
    private Long id;
    private String title;
    private String image;
    private String content;

    public BlogPostDto(BlogPost blogPost) {
        this.id = blogPost.getId();
        this.title = blogPost.getTitle();
        this.image = blogPost.getImage();
        this.content = blogPost.getContent();
    }

    public BlogPost toBlogPost(){
        BlogPost blogPost = new BlogPost();
        blogPost.setId(this.id);
        blogPost.setTitle(this.title);
        blogPost.setImage(this.image);
        blogPost.setContent(this.content);
        return blogPost;
    }
}

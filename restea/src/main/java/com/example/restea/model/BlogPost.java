package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "blog_post")
@Getter
@Setter
@ToString
public class BlogPost extends BaseEntity{
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
}

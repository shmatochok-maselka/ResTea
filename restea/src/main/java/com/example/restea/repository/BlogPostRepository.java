package com.example.restea.repository;

import com.example.restea.model.BlogPost;
import com.example.restea.model.ProductFlavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}

package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final NaverOpenApiTemplate naverBlogTemplate;

    public BlogService(NaverOpenApiTemplate naverBlogTemplate) {
        this.naverBlogTemplate = naverBlogTemplate;
    }

    public ResponseBlogDTO findByQuery(String query){
        return naverBlogTemplate.findByQuery(query);
    }
}
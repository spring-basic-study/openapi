package com.example.demo.controller;

import com.example.demo.service.ResponseBlogDTO;
import com.example.demo.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SearchController {

    private final BlogService blogService;

    @GetMapping("/blog")
    public ResponseBlogDTO findBlog(@RequestParam(name = "q") String query){

        return blogService.findByQuery(query);
    }
}
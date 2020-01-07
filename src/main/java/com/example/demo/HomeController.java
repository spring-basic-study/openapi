package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final BlogService blogService;

    public HomeController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public ResponseEntity<ResponseNaverBlog> getTest(){

        return blogService.findByQuery("스프링부트");
    }

}

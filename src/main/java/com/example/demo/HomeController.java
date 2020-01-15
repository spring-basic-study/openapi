package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final BlogService blogService;

    public HomeController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public ResponseEntity<ResponseNaverBlog> Search(@RequestParam("query") String apiSearch){
        return getTest(apiSearch);
    }

    public ResponseEntity<ResponseNaverBlog> getTest(String blogSearch){
        return blogService.findByQuery(blogSearch);
    }

}

package com.example.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.ResponseNaverBlog;
import com.example.Model.ResponseNaverBlogAndMovie;
import com.example.Model.ResponseNaverMovie;
import com.example.Service.BlogAndMovieService;
import com.example.Service.BlogService;
import com.example.Service.MovieService;


@RestController
@RequestMapping("/api")
public class HomeController {

    private final BlogService blogService;
    private final MovieService movieService;
    private final BlogAndMovieService blogandmovieService; 

    public HomeController(BlogService blogService,MovieService movieService, BlogAndMovieService blogandmovieService) {
        this.blogService = blogService;
        this.movieService= movieService;
        this.blogandmovieService= blogandmovieService;
    }

    @GetMapping("/blog")
    public ResponseEntity<ResponseNaverBlog> getBlog(@RequestParam(value="query") String query){
        try {
            Thread.sleep(2800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return blogService.findByQuery(query);
    }
    @GetMapping("/movie")
    public ResponseEntity<ResponseNaverMovie> getMovie(@RequestParam(value="query") String query){
        try {
            Thread.sleep(2800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	return movieService.findByQeury(query);
    }
    @GetMapping("/blogandmovie")
    public ResponseEntity<String> getBlogandMovie(@RequestParam(value="query")String query){
        try {
            Thread.sleep(2800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	return blogandmovieService.findByQuery(query);
    	
    }
}
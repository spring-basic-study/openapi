package com.example.openapi.controller;

import com.example.openapi.SearchProperties;
import com.example.openapi.repository.Blog;
import com.example.openapi.repository.Movie;
import com.example.openapi.repository.Result;
import com.example.openapi.service.CombineSearchService;
import com.example.openapi.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    private final SearchService searchService;
    private final CombineSearchService combineSearchService;
    private final SearchProperties searchProperties; 

    public SearchController(SearchService searchService, SearchProperties searchProperties,
                            CombineSearchService combineSearchService){ //@Autowired말고 생성자로 주입하기
        this.searchProperties = searchProperties;
        this.searchService = searchService;
        this.combineSearchService = combineSearchService;
    }

    @GetMapping("/search")
    public List<Result> search(@RequestParam(name = "query") String query){
        Blog blog = (Blog) searchService.search(searchProperties.getBlogUrl(), query, Blog.class);
        Movie movie = (Movie) searchService.search(searchProperties.getMovieUrl(), query, Movie.class);
        return combineSearchService.combine(blog,movie);
    }

    @GetMapping("/blog")
    public Result blogSearch(@RequestParam(name = "query") String query){
        return searchService.search(searchProperties.getBlogUrl(),query, Blog.class);
    }

    @GetMapping("/movie")
    public Result movieSearch(@RequestParam(name = "query") String query){
        return searchService.search(searchProperties.getMovieUrl(),query, Movie.class);
    }
}

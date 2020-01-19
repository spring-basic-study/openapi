package com.example.openapi.controller;

import com.example.openapi.SearchProperties;
import com.example.openapi.repository.BlogSearchResponse;
import com.example.openapi.repository.MovieSearchResponse;
import com.example.openapi.repository.SearchResponse;
import com.example.openapi.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    private static final int LIMIT_ITEM_COUNT = 5;
    private final SearchService searchService;
    private SearchProperties searchProperties;

    public SearchController(SearchService searchService, SearchProperties searchProperties){ //@Autowired말고 생성자로 주입하기
        this.searchProperties = searchProperties;
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<SearchResponse> search(@RequestParam(name = "query") String query){ //다른데서 limit 로직 처리하도록 수정하기
        List<SearchResponse> list = new LinkedList<SearchResponse>();

        BlogSearchResponse blogSearchResponse = (BlogSearchResponse) searchService.search(searchProperties.getBlogUrl(), query, BlogSearchResponse.class);
        MovieSearchResponse movieSearchResponse = (MovieSearchResponse) searchService.search(searchProperties.getMovieUrl(), query, MovieSearchResponse.class);

        List<BlogSearchResponse.SearchResult> blogItems = new LinkedList<BlogSearchResponse.SearchResult>();
        List<MovieSearchResponse.MovieSearchResult> movieItems = new LinkedList<MovieSearchResponse.MovieSearchResult>();

        for(int i=0;i<LIMIT_ITEM_COUNT;i++){
            movieItems.add(movieSearchResponse.getItems().get(i));
            blogItems.add(blogSearchResponse.getItems().get(i));
        }

        blogSearchResponse.setItems(blogItems);
        movieSearchResponse.setItems(movieItems);

        list.add(blogSearchResponse); //return list
        list.add(movieSearchResponse);

        return list;
    }

    @GetMapping("/blog")
    public SearchResponse blogSearch(@RequestParam(name = "query") String query){
        return searchService.search(searchProperties.getBlogUrl(),query,BlogSearchResponse.class);
    }

    @GetMapping("/movie")
    public SearchResponse movieSearch(@RequestParam(name = "query") String query){
        return searchService.search(searchProperties.getMovieUrl(),query,MovieSearchResponse.class);
    }
}

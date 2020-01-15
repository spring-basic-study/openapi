package com.example.openapi.controller;

import com.example.openapi.repository.BlogSearchResponse;
import com.example.openapi.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final SearchService searchService;

    public HomeController(SearchService searchService){ //@Autowired말고 생성자로 주입하기
        this.searchService = searchService;
    }

    @GetMapping("/api/search")
    public ResponseEntity<BlogSearchResponse> search(String query){
        return searchService.search(query);
    }
}

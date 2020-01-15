package com.example.openapi.controller;

import com.example.openapi.repository.SearchResponse;
import com.example.openapi.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    SearchService searchService;

    public HomeController(SearchService searchService){ //@Autowired말고 생성자로 주입하기
        this.searchService = searchService;
    }

    @GetMapping("/api/search")
    public ResponseEntity<SearchResponse> search(String q){
        return searchService.search(q);
    }
}

package com.example.openapi.service;

import com.example.openapi.SearchProperties;
import com.example.openapi.repository.BlogSearchResponse;
import com.example.openapi.repository.MovieSearchResponse;
import com.example.openapi.repository.SearchResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service
public class SearchService {
    private final RestTemplate restTemplate;
    private final SearchProperties searchProperties;

    SearchService(SearchProperties searchProperties, RestTemplate restTemplate){
        this.searchProperties = searchProperties;
        this.restTemplate = restTemplate;
    }
    public SearchResponse search(String url, String query,Class<? extends SearchResponse> responseType){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", searchProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", searchProperties.getClientSecret());
        String searchUrl = url + "?query=" + query;
        SearchResponse searchResponse = restTemplate.exchange(searchUrl, HttpMethod.GET, new HttpEntity(httpHeaders),
                responseType).getBody();
        return searchResponse;
    }
}

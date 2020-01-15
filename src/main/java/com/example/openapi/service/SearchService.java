package com.example.openapi.service;

import com.example.openapi.SearchProperties;
import com.example.openapi.repository.BlogSearchResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchService {
    private final RestTemplate restTemplate;
    private final SearchProperties searchProperties;

    SearchService(SearchProperties searchProperties, RestTemplate restTemplate){
        this.searchProperties = searchProperties;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<BlogSearchResponse> search(String text){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", searchProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", searchProperties.getClientSecret());
        String blogUrl = searchProperties.getBlogUrl() + "?query=" + text + "?start=" + 2;
        String movieUrl = searchProperties.getMovieUrl() + "?query=" + text;
        return restTemplate.exchange(blogUrl, HttpMethod.GET, new HttpEntity(httpHeaders), BlogSearchResponse.class);
    }
}

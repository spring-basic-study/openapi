package com.example.openapi.service;

import com.example.openapi.BlogProperties;
import com.example.openapi.repository.SearchResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchService {
    RestTemplate restTemplate;
    BlogProperties blogProperties;
    SearchService(BlogProperties blogProperties, RestTemplate restTemplate){
        this.blogProperties = blogProperties;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<SearchResponse> Search(String text){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", blogProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", blogProperties.getClientSecret());
        String url = blogProperties.getSearchUrl() + "?query=" + text;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), SearchResponse.class);
    }
}

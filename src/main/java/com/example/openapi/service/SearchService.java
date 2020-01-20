package com.example.openapi.service;

import com.example.openapi.SearchProperties;
import com.example.openapi.repository.Result;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SearchService {
    private final RestTemplate restTemplate;
    private final SearchProperties searchProperties;

    SearchService(SearchProperties searchProperties, RestTemplate restTemplate){
        this.searchProperties = searchProperties;
        this.restTemplate = restTemplate;
    }
    public Result search(String url, String query, Class<? extends Result> resultType){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", searchProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", searchProperties.getClientSecret());
        String searchUrl = url + "?query=" + query;
        Result result = restTemplate.exchange(searchUrl, HttpMethod.GET, new HttpEntity(httpHeaders),
                resultType).getBody();
        return result;
    }
}

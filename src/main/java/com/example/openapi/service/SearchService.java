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

    public  List<SearchResponse> search(String text){
        List<SearchResponse> list = new LinkedList<SearchResponse>();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", searchProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", searchProperties.getClientSecret());
        String blogUrl = searchProperties.getBlogUrl() + "?query=" + text + "?start=" + 2;
        String movieUrl = searchProperties.getMovieUrl() + "?query=" + text;
        list.add(restTemplate.exchange(blogUrl, HttpMethod.GET, new HttpEntity(httpHeaders), BlogSearchResponse.class).getBody());
        list.add(restTemplate.exchange(movieUrl, HttpMethod.GET, new HttpEntity(httpHeaders), MovieSearchResponse.class).getBody());
        return list;
    }
}

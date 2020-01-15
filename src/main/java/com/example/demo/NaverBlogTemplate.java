package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NaverBlogTemplate {

    private String naverOpenApiUrl;

    private String naverOpenApiClientId;

    private String naverOpenApiClientSecret;

    public NaverBlogTemplate(String naverOpenApiUrl, String naverOpenApiClientId, String naverOpenApiClientSecret){
        this.naverOpenApiUrl = naverOpenApiUrl;
        this.naverOpenApiClientId = naverOpenApiClientId;
        this.naverOpenApiClientSecret = naverOpenApiClientSecret;
    }

    public ResponseEntity<ResponseNaverBlog> findBlogByQuery(String query) {

        //TODO: 코드 리팩토링

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverOpenApiClientId);
        httpHeaders.add("X-Naver-Client-Secret", naverOpenApiClientSecret);

        String url = naverOpenApiUrl + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseNaverBlog.class);
    }
}
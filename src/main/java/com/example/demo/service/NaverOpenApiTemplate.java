package com.example.demo.service;

import com.example.demo.config.NaverOpenApiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableConfigurationProperties({ NaverOpenApiProperties.class })
public class NaverOpenApiTemplate {

    private final NaverOpenApiProperties naverOpenApiProperties;
    private final RestTemplate restTemplate;

    public NaverOpenApiTemplate(NaverOpenApiProperties naverOpenApiProperties, RestTemplate restTemplate) {
        this.naverOpenApiProperties = naverOpenApiProperties;
        this.restTemplate = restTemplate;
    }

    public ResponseBlogDTO findByQuery(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverOpenApiProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverOpenApiProperties.getClientSecret());
        String url = naverOpenApiProperties.getBlogUrl() + "?query=" + query;
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseBlogDTO.class).getBody();
    }
}

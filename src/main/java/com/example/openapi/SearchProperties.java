package com.example.openapi;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration //Bean으로 관리하기 위해서
@PropertySource(value = "file:/Users/hwangseon-a/api-properties/application.properties", ignoreResourceNotFound = true)
public class SearchProperties {
    @Value("${naver.openapi.blog-url}")
    private String blogUrl;

    @Value("${naver.openapi.movie-url}")
    private String movieUrl;

    @Value("${naver.openapi.clientId}")
    private String clientId;

    @Value("${naver.openapi.clientSecret}")
    private String clientSecret;
}
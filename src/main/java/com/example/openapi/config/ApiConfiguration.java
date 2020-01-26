package com.example.openapi.config;

import com.example.openapi.SearchProperties;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory factory
                = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(10*1000); //timeout 설정
        factory.setReadTimeout(10*1000);
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100) // 최대 커넥션 갯수
                .setMaxConnPerRoute(5) // IP/domain name당 최대 커넥션 갯수
                .build();
        factory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
}

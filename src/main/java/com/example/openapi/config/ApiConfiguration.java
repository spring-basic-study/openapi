package com.example.openapi.config;

import com.example.openapi.SearchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({SearchProperties.class})
public class ApiConfiguration {
    @Bean
    public RestTemplate restTemplate(){ //질문
        HttpComponentsClientHttpRequestFactory factory
                = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(10*1000); //몇초가 적당한 시간인지?
        factory.setReadTimeout(10*1000);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
}

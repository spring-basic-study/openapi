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
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory factory
                = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(30*1000); //30초
        factory.setReadTimeout(30*1000);
        return new RestTemplate(factory);
    }
}

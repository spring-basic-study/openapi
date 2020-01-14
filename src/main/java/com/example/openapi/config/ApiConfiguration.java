package com.example.openapi.config;

import com.example.openapi.BlogProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({BlogProperties.class})
public class ApiConfiguration {
    @Bean
    public BlogProperties blogProperties(){
       return new BlogProperties();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

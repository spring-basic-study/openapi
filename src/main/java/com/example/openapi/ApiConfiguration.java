package com.example.openapi;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({BlogProperties.class})
public class ApiConfiguration {
    private final BlogProperties blogProperties;
    public ApiConfiguration(BlogProperties blogProperties){
        this.blogProperties = blogProperties;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

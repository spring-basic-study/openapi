package com.example.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ NaverBlogProperties.class })
public class BlogAutoConfiguration {

    private final NaverBlogProperties naverBlogProperties;

    public BlogAutoConfiguration(NaverBlogProperties naverBlogProperties) {
        this.naverBlogProperties = naverBlogProperties;
    }

    @Bean
    public NaverBlogTemplate naverBlogTemplate(){
        return new NaverBlogTemplate(naverBlogProperties.getBlogUrl(), naverBlogProperties.getClientId(), naverBlogProperties.getClientSecret());
    }
}
package com.example.openapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "naver.openapi")
public class BlogProperties {
    private String searchUrl;
    private String clientId;
    private String clientSecret;
}

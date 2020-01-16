package com.example.openapi.config;

import com.example.openapi.SearchProperties;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

@Configuration
@EnableConfigurationProperties({SearchProperties.class})
public class ApiConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory factory
                = new HttpComponentsClientHttpRequestFactory();
        CloseableHttpClient client = HttpClientBuilder.create().setMaxConnTotal(50).setMaxConnPerRoute(20).build();
        factory.setConnectTimeout(10*1000);
        factory.setReadTimeout(10*1000);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
}

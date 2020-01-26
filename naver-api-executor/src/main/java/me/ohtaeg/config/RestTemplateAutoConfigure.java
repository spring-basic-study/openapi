package me.ohtaeg.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(RestTemplateProperties.class)
public class RestTemplateAutoConfigure {

    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateProperties restTemplateProperties) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(restTemplateProperties.getMaxConnectionTotal())
                .setMaxConnPerRoute(restTemplateProperties.getMaxConnectionRoute())
                .build();

        factory.setHttpClient(httpClient);
        factory.setConnectTimeout(restTemplateProperties.getConnectionTimeout());
        factory.setReadTimeout(restTemplateProperties.getReadTimeout());
        return new RestTemplate(factory);
    }
}

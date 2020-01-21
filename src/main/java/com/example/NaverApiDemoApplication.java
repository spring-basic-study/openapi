package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.Service.BlogService;

import info.naver_openapi_info;

@SpringBootApplication
public class NaverApiDemoApplication {

	
	public static void main(String[] args) {
		SpringApplication springapplication = new SpringApplication(NaverApiDemoApplication.class);
		springapplication.run(args);
		//SpringApplication.run(NaverApiDemoApplication.class, args);
	}
		


}

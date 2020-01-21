package com.example.Config;
//package config;
//
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import info.naver_openapi_info;
//@Profile("local")
//@Configuration
//@EnableConfigurationProperties(naver_openapi_info.class)
//public class ProfileLocal {
//	
//	private final naver_openapi_info info;
//	
//	public ProfileLocal(naver_openapi_info info) {
//		this.info= info;
//	}
//	
//  @Bean
//  public String blogUrl() {
//	  return "https://openapi.naver.com/v1/search/blog.json";
//  }
//  @Bean
//  public String clientId() {
//	  return this.info.getClientId();
//  }
//  @Bean
//  public String clientSecret() {
//	  return this.info.getClientSecret();
//  }
//}

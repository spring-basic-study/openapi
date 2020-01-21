package com.example.Service;
import org.apache.catalina.core.ApplicationContext;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Model.ResponseNaverBlog;
import com.example.Model.ResponseNaverBlogAndMovie;

import info.naver_openapi_info;

@Service
@EnableConfigurationProperties(naver_openapi_info.class)
@Component
public class BlogService {

   /* @Value("${naver.openapi.blogUrl}")//application.properties 파일에서 설정한 전역변수드릉ㄹ 사용할 수 있다.
    private String naverOpenApiUrl;

   @Value("${naver.openapi.clientId}")
    private String naverOpenApiClientId;

    @Value("${naver.openapi.clientSecret}")
    private String naverOpenApiClientSecret;
    */
	
	//@ConfigurationProperties, @EnableConfigurationProperties  사용해서 의존성 주입
	private final naver_openapi_info info;

	
	public BlogService(naver_openapi_info info) {
		this.info= info;
	}
	
	//profile설정파일 에서 @ConfigurationProperties, @EnableConfigurationProperties을 주입해서 
	//각 변수들을 bean으로지정해주었고, application.properties 에서 spring.profiles.active=local 를 이용해서 
	//프로파일사용을 알렸으며 , compoent 어토노테이션을 통해 프로파일설정파일에서 bean 으로 지정된 것들을 autowired해서 사용할수 있게 하엿다.
//	@Autowired
//	private String blogUrl;
//	@Autowired
//	private String clientId;
//	@Autowired
//	private String clientSecret;
	@Autowired
	private RestTemplate resttemplate;
	
    public ResponseEntity<ResponseNaverBlog> findByQuery(String query){
    //response 는 응답resource 에 대한	representation 을 반환해준다.
    	
    	
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", info.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", info.getClientSecret());

        String url= info.getBlogUrl()+"?query="+query;

        return resttemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseNaverBlog.class);

    }


}
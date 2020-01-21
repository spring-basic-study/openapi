package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Model.ResponseNaverBlogAndMovie;

import info.naver_openapi_info;
@Service
public class BlogAndMovieService {

	@Autowired
	RestTemplate resttemplate;
	private final naver_openapi_info info;
	public BlogAndMovieService(naver_openapi_info info) {
		this.info= info;
	}
	
	public ResponseEntity<String> findByQuery(String query){
		System.out.println("안녕1");
		String url = info.getBlogUrl()+"?query="+query;
		String url2= info.getMovieUrl()+"?query="+query;
		HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", info.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", info.getClientSecret());
		
		ResponseEntity<ResponseNaverBlogAndMovie> a=  resttemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseNaverBlogAndMovie.class);
		String a1= a.getBody().toString();

ResponseEntity<ResponseNaverBlogAndMovie> b=  resttemplate.exchange(url2, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseNaverBlogAndMovie.class);
String b1= b.getBody().toString();
String c1=a1.concat(b1);
ResponseEntity<String> c= new ResponseEntity<String>(c1,HttpStatus.OK);
return c;
	
		
	}
}

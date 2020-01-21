package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Model.ResponseNaverBlog;
import com.example.Model.ResponseNaverMovie;

import info.naver_openapi_info;
@Service
@Component
public class MovieService {
	
	@Autowired
	private RestTemplate resttemplate;
	private final naver_openapi_info info;	
	public MovieService(naver_openapi_info info) {
		this.info= info;
	}

	
	public ResponseEntity<ResponseNaverMovie> findByQeury(String query) {

		String url= info.getMovieUrl()+"?query="+query;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", info.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", info.getClientSecret());
		
		return resttemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseNaverMovie.class);

		
		
	}

}

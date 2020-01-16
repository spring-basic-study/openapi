package me.ohtaeg.domain.repository;

import me.ohtaeg.domain.response.SearchApi;
import org.springframework.http.HttpHeaders;

public interface SearchRepository {

    SearchApi search(SearchApi searchApi, final Class<? extends SearchApi> returnType);

    default HttpHeaders getHeader(String id, String secret) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", id);
        httpHeaders.add("X-Naver-Client-Secret", secret);
        return httpHeaders;
    }
}

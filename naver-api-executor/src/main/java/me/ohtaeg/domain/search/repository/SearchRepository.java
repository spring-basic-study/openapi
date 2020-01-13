package me.ohtaeg.domain.search.repository;

import me.ohtaeg.api.dto.SearchWord;
import me.ohtaeg.domain.response.OpenApi;
import me.ohtaeg.domain.search.RequestVariableName;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;

public interface SearchRepository<T extends OpenApi> {
    String UTF_8 = "UTF-8";

    ResponseEntity<T> search(SearchWord searchWord) throws UnsupportedEncodingException;

    // TODO : refactor - repo interface가 header에 대한 default 메서드를 갖고있는게 맞을까?
    default HttpHeaders getHeader(String id, String secret) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", id);
        httpHeaders.add("X-Naver-Client-Secret", secret);
        return httpHeaders;
    }

    default UriComponents getUriBuilder(final String url, final SearchWord searchWord) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(RequestVariableName.QUERY.getName(), searchWord.getQuery())
                .queryParam(RequestVariableName.DISPLAY.getName(), searchWord.getDisplay())
                .queryParam(RequestVariableName.START.getName(), searchWord.getStart())
                .queryParam(RequestVariableName.SORT.getName(), searchWord.getSort())
                .build();
    }
}

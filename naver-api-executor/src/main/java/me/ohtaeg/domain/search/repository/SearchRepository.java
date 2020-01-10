package me.ohtaeg.domain.search.repository;

import me.ohtaeg.api.dto.SearchWord;
import me.ohtaeg.domain.response.Blog;
import me.ohtaeg.domain.search.RequestVariableName;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public interface SearchRepository {
    String UTF_8 = "UTF-8";

    Blog search(SearchWord searchWord) throws UnsupportedEncodingException;

    // TODO : refactor - repo interface가 header에 대한 default 메서드를 갖고있는게 맞을까?
    default HttpHeaders getHeader(String id, String secret) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", id);
        httpHeaders.add("X-Naver-Client-Secret", secret);
        return httpHeaders;
    }

    default UriComponentsBuilder getUriBuilder(final String url, final SearchWord searchWord) throws UnsupportedEncodingException {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(RequestVariableName.QUERY.getName(), URLEncoder.encode(searchWord.getQuery(), UTF_8))
                .queryParam(RequestVariableName.DISPLAY.getName(), searchWord.getDisplay())
                .queryParam(RequestVariableName.START.getName(), searchWord.getStart())
                .queryParam(RequestVariableName.SORT.getName(), searchWord.getSort());
    }
}

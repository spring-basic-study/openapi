package me.ohtaeg.infra;

import config.NaverApiProperties;
import me.ohtaeg.domain.response.Blog;
import me.ohtaeg.api.dto.SearchWord;
import me.ohtaeg.domain.search.repository.SearchRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;

@Repository
public class BlogRepository implements SearchRepository {

    // TODO : refactoring - Repository가 properties와 restTemplate를 갖고있는게 맞을까?
    private NaverApiProperties naverApiProperties;
    private RestTemplate restTemplate;

    public BlogRepository(NaverApiProperties naverApiProperties, RestTemplate restTemplate) {
        this.naverApiProperties = naverApiProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public Blog search(final SearchWord searchWord) throws UnsupportedEncodingException {
        UriComponentsBuilder builder = getUriBuilder(naverApiProperties.getUrl(), searchWord);

        HttpHeaders httpHeaders = getHeader(naverApiProperties.getClientId(), naverApiProperties.getClientSecret());

        return restTemplate.exchange(builder.toUriString()
                                     , HttpMethod.GET
                                     , new HttpEntity<>(httpHeaders)
                                     , Blog.class).getBody();
    }
}

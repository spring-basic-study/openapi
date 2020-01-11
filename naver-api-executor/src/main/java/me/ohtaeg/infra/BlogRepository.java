package me.ohtaeg.infra;

import config.NaverApiProperties;
import me.ohtaeg.api.dto.SearchWord;
import me.ohtaeg.domain.response.Blog;
import me.ohtaeg.domain.search.repository.SearchRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

@Repository
public class BlogRepository implements SearchRepository<Blog> {

    // TODO : refactoring - Repository가 properties와 restTemplate를 갖고있는게 맞을까?
    private NaverApiProperties naverApiProperties;
    private RestTemplate restTemplate;

    public BlogRepository(NaverApiProperties naverApiProperties, RestTemplate restTemplate) {
        this.naverApiProperties = naverApiProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Blog> search(final SearchWord searchWord) {
        UriComponents uriComponents = getUriBuilder(naverApiProperties.getUrl(), searchWord);
        HttpHeaders httpHeaders = getHeader(naverApiProperties.getClientId(), naverApiProperties.getClientSecret());

        return restTemplate.exchange(uriComponents.toUriString()
                                      , HttpMethod.GET
                                      , new HttpEntity<>(httpHeaders)
                                      , Blog.class);
    }
}

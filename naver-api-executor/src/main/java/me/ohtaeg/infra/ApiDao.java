package me.ohtaeg.infra;

import me.ohtaeg.domain.repository.SearchRepository;
import me.ohtaeg.domain.response.SearchApi;
import me.ohtaeg.util.PropertyUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ApiDao implements SearchRepository {

    private RestTemplate restTemplate;

    public ApiDao(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SearchApi search(final SearchApi searchApi, final Class<? extends SearchApi> clazz) {
        HttpHeaders httpHeaders = getHeader(PropertyUtils.getClientId(), PropertyUtils.getSecret());
        return restTemplate.exchange(searchApi.getUri()
                , HttpMethod.GET
                , new HttpEntity<>(httpHeaders)
                , clazz).getBody();
    }
}

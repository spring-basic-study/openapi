package me.ohtaeg.domain.response;


import me.ohtaeg.api.dto.request.MovieRequest;
import me.ohtaeg.api.dto.request.SearchWord;
import me.ohtaeg.domain.response.constant.RequestVariableName;
import me.ohtaeg.util.PropertyUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class Movie extends SearchApi implements Limitable {
    private static final String SEARCH_RESOURCE = "/movie";
    private List<Item> items;

    protected Movie() { }
    public Movie(final SearchWord searchWord) {
        super.uri = createUri(searchWord);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    String createUri(final SearchWord searchWord) {
        MovieRequest movieRequest = (MovieRequest) searchWord;
        return UriComponentsBuilder.fromHttpUrl(PropertyUtils.getInstance().getUrl() + SEARCH_RESOURCE)
                .queryParam(RequestVariableName.QUERY.getName(), movieRequest.getQuery())
                .queryParam(RequestVariableName.DISPLAY.getName(), movieRequest.getDisplay())
                .queryParam(RequestVariableName.START.getName(), movieRequest.getStart())
                .build().toUriString();
    }

    @Override
    public void limit(final int length) {
        if (CollectionUtils.isEmpty(items)) {
            return;
        }

        super.limitLength = length;
        this.items = items.stream()
                .limit(length)
                .collect(Collectors.toList());
    }

    private static class Item {
        String title;
        String link;
        String subtitle;
        String actor;
        String userRating;

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getActor() {
            return actor;
        }

        public String getUserRating() {
            return userRating;
        }
    }
}

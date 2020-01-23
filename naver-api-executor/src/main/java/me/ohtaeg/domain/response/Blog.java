package me.ohtaeg.domain.response;

import me.ohtaeg.api.dto.request.BlogRequest;
import me.ohtaeg.api.dto.request.SearchWord;
import me.ohtaeg.domain.response.constant.RequestVariableName;
import me.ohtaeg.util.PropertyUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class Blog extends SearchApi implements Limitable {
    private static final String SEARCH_RESOURCE = "/blog";
    private List<Item> items;

    protected Blog() { }
    public Blog(final SearchWord searchWord) {
        super.uri= createUri(searchWord);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    String createUri(final SearchWord searchWord) {
        BlogRequest blogRequest = (BlogRequest) searchWord;
        return UriComponentsBuilder.fromHttpUrl(PropertyUtils.getInstance().getUrl() + SEARCH_RESOURCE)
                .queryParam(RequestVariableName.QUERY.getName(), blogRequest.getQuery())
                .queryParam(RequestVariableName.DISPLAY.getName(), blogRequest.getDisplay())
                .queryParam(RequestVariableName.START.getName(), blogRequest.getStart())
                .queryParam(RequestVariableName.SORT.getName(), blogRequest.getSort())
                .build().toUriString();
    }

    //TODO : Refactoring.. 여기서 구현하는게 맞을까, item을 별도로 추상화 해야할듯함.
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
        String description;
        String bloggername;
        String bloggerlink;

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getDescription() {
            return description;
        }

        public String getBloggername() {
            return bloggername;
        }

        public String getBloggerlink() {
            return bloggerlink;
        }
    }
}

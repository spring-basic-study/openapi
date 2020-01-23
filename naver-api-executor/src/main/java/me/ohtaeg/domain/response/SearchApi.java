package me.ohtaeg.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.ohtaeg.api.dto.request.SearchWord;

public abstract class SearchApi {
    @JsonIgnore
    protected String uri;
    protected Integer total;
    protected Integer display;
    protected int limitLength = 0;

    abstract String createUri(SearchWord searchWord);

    public String getUri() {
        return uri;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getDisplay() {
        return display;
    }

    public int getLimitLength() {
        return limitLength;
    }
}

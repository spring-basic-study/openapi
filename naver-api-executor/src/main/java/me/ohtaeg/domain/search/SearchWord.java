package me.ohtaeg.domain.search;

import me.ohtaeg.domain.search.exception.NoQueryException;
import org.springframework.util.StringUtils;

public class SearchWord {
    private String query;
    private int display;
    private int start;
    private String sort;

    public SearchWord(final String query) {
        validNecessaryQuery(query);
        this.query = query;
        this.display = 3;
        this.start = 1;
        this.sort = "sim";
    }

    public String getQuery() {
        return query;
    }

    public int getDisplay() {
        return display;
    }

    public int getStart() {
        return start;
    }

    public String getSort() {
        return sort;
    }

    private void validNecessaryQuery(String query) {
        if (StringUtils.isEmpty(query)) {
            throw new NoQueryException(query);
        }
    }
}

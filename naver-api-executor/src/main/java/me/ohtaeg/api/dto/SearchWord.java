package me.ohtaeg.api.dto;

import me.ohtaeg.domain.search.exception.NoQueryException;
import org.springframework.util.StringUtils;

public class SearchWord {
    private final String query;
    private int display;
    private int start;
    private String sort;

    public SearchWord(final String query, final int display, final int start, final String sort) {
        // TODO 삼항연산자 메소드로 추출.
        this.query = validNecessaryQuery(query);
        this.display = (display == 0) ? 1 : display;
        this.start = (start == 0) ? 1 : start;;
        this.sort = (StringUtils.isEmpty(sort)) ? "sim" : sort;
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

    private String validNecessaryQuery(String query) {
        if (StringUtils.isEmpty(query)) {
            throw new NoQueryException(query);
        }
        return query;
    }
}

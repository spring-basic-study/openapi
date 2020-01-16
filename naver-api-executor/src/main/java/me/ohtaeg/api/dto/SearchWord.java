package me.ohtaeg.api.dto;

import javax.validation.constraints.NotBlank;

public class SearchWord {
    @NotBlank(message = "쿼리는 필수값 입니다.")
    protected final String query;
    protected int display = 1;
    protected int start = 1;

    public SearchWord(final String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(final int display) {
        this.display = display;
    }

    public int getStart() {
        return start;
    }

    public void setStart(final int start) {
        this.start = start;
    }

}

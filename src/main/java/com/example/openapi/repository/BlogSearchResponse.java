package com.example.openapi.repository;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlogSearchResponse {
    private int total;
    private int start;
    private int display;
    private List<SearchResult> items;

    @Getter
    @Setter
    public class SearchResult {
        private String title;
        private String link;
        private String description;
        private String bloggername;
        private String bloggerlink;
    }
}

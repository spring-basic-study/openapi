package com.example.openapi.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SearchResult {
    private String title;
    private String link;
    private String description;
    private String bloggerName;
    private String bloggerLink;
}

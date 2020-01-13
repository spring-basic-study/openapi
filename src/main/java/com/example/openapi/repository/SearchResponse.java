package com.example.openapi.repository;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResponse {
    private int total;
    private int start;
    private int display;
    private List<SearchResult> items;
}

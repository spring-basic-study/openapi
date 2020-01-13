package com.example.openapi.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class SearchResponse {
    private int total;
    private int start;
    private int display;
    private List<SearchResult> items;
}

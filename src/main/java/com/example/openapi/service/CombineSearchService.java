package com.example.openapi.service;

import com.example.openapi.repository.Blog;
import com.example.openapi.repository.Movie;
import com.example.openapi.repository.Result;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombineSearchService {
    private static final int LIMIT_ITEM_COUNT = 10;

    public List<Result> combine(Blog blog, Movie movie){
        List<Result> results = new LinkedList<Result>();
        blog.setItems(blog.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
        movie.setItems(movie.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
        results.add(blog);
        results.add(movie);
        return results;
    }
}

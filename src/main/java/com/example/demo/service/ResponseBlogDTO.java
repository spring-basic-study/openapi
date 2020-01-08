package com.example.demo.service;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ResponseBlogDTO implements Serializable {

    private Integer total;
    private List<Article> items;

    @Getter
    @Setter
    public static class Article{
        String title;
        String link;
        String bloggername;
        String description;
        String postdate;
    }
}

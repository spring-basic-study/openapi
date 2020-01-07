package com.example.demo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseNaverBlog implements Serializable {

    private Integer total;
    private List<naverDocument> items;

    @Data
    public static class naverDocument{
        String title;
        String link;
        String bloggername;
        String description;
        String postdate;
    }
}

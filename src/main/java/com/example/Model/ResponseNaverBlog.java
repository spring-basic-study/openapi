package com.example.Model;
import java.io.Serializable;

import java.util.List;

import lombok.Data;
@Data
public class ResponseNaverBlog  {
	private Integer total;
    private List<naverDocument> items;
    
    @Data
	public static class naverDocument{
        String title;
        String link;
        String bloggername;
        String description;
        String postdate;
        String aa;
    }
    

}
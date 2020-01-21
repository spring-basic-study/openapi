package com.example.Model;

import java.sql.Date;
import java.util.List;

import lombok.Data;
@Data
public class ResponseNaverBlogAndMovie {
	private Integer total;
	private List<NaverDocumentAndMovie> items;
	
	@Data
	private static class NaverDocumentAndMovie{
         String title;
        String link;
        String bloggername;
        String description;
        String postdate;
		 String subtitle;
		 Date pubDate;
		 String director;

	}
}

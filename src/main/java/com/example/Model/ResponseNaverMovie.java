package com.example.Model;

import java.util.List;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
@Data
public class ResponseNaverMovie implements Serializable{
	private Integer total;
	private List<naverMovie> items;
	@Data
	public static class naverMovie{
		private String title;
		private String subtitle;
		private Date pubDate;
		private String director;
	}
}

package com.ep.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private String bno;
	private String title;
	private String writer;
	private String content;
	private Date writeDate;
	private Date updateDate;
	
}

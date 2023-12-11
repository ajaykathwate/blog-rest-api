package com.akkykaths.blog.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
	
	private int id;

	private String commentor;
	
	private String comment;

}

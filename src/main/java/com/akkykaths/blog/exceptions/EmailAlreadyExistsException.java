package com.akkykaths.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class EmailAlreadyExistsException extends RuntimeException  {
	
	String msg;

	public EmailAlreadyExistsException(String msg) {
		super(String.format("%s already exists !!", msg));
		this.msg = msg;
	}
	
}

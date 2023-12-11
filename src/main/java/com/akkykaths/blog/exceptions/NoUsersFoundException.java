package com.akkykaths.blog.exceptions;

@SuppressWarnings("serial")
public class NoUsersFoundException extends RuntimeException {
	
	public NoUsersFoundException() {
		super("No Users found !!");
	}

}

package com.lcwd.user.service.UserService.exceptions;

public class ResourceNotFound extends RuntimeException{

	public ResourceNotFound() {
		super("Resource Not found on server");
	}
	
	public ResourceNotFound(String msg) {
		super(msg);
	}
}

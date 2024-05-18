package com.lcwd.hotel.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException (String msg) {
		super(msg);
	}
	
	public ResourceNotFoundException () {
		super();
	}
}

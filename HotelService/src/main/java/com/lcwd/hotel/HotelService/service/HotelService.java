package com.lcwd.hotel.HotelService.service;

import java.util.List;
import java.util.Optional;

import com.lcwd.hotel.HotelService.entities.Hotel;

public interface HotelService {

	// create
	Hotel createHotel(Hotel hotel);
	
	//get all 
	List<Hotel> getAllHotels();
	
	// single get 
	Hotel getAHotel(String id);
	
}

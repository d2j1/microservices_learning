package com.lcwd.hotel.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.HotelService.entities.Hotel;
import com.lcwd.hotel.HotelService.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	
	// create 
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		
		Hotel hotel1 = hotelService.createHotel(hotel);
		
		return  new ResponseEntity<>(hotel1, HttpStatus.CREATED);
		
	}
	
	
	// get single 
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
		
		Hotel hotel1 = hotelService.getAHotel(hotelId);
		
		return  new ResponseEntity<>(hotel1, HttpStatus.ACCEPTED);
		
	}
	
	// get all 
	@GetMapping
	public ResponseEntity<List<Hotel>> getHotels() {
		
		List<Hotel> hotel1 = hotelService.getAllHotels();
		
		return  new ResponseEntity<>(hotel1, HttpStatus.ACCEPTED);
		
	}
	
}

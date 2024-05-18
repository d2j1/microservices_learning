package com.lcwd.hotel.HotelService.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.HotelService.entities.Hotel;
import com.lcwd.hotel.HotelService.exception.ResourceNotFoundException;
import com.lcwd.hotel.HotelService.repository.HotelRepo;
import com.lcwd.hotel.HotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getAHotel(String id) {
		
		return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Requested resource with given id not found!"));
	}
	
	
}

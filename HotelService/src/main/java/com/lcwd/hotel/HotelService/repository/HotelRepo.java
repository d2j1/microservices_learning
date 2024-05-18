package com.lcwd.hotel.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.HotelService.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}

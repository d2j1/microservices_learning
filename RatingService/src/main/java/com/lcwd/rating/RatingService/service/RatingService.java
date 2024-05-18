package com.lcwd.rating.RatingService.service;

import java.util.List;

import com.lcwd.rating.RatingService.entities.Rating;

public interface RatingService {
	
	// create 
	
	Rating createRating(Rating rating);
	
	
	//	get all
	List<Rating> getAllRating();
	
	//	 get all rating by user
	List<Rating> getAllRatingByUser(String userId);
	
//	 get all by hotel 	
	List<Rating> getAllRatingOfHotel(String hotelId);
}

package com.lcwd.rating.RatingService.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repository.RatingRepository;
import com.lcwd.rating.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	
	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUser(String userId) {
		
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingOfHotel(String hotelId) {
		
		return ratingRepo.findByHotelId(hotelId);
	}
	
	
}

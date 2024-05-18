package com.lcwd.rating.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.implementation.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingService;

	// create a rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {

		Rating rating1 = ratingService.createRating(rating);

		return new ResponseEntity<Rating>(rating1, HttpStatus.CREATED);
	}

// get all ratings 
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {

		List<Rating> rating1 = ratingService.getAllRating();

		return new ResponseEntity<List<Rating>>(rating1, HttpStatus.ACCEPTED);
	}

	// get all ratings by user
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userId) {

		List<Rating> rating1 = ratingService.getAllRatingByUser(userId);

		return new ResponseEntity<List<Rating>>(rating1, HttpStatus.ACCEPTED);
	}

	// get all ratings by hotel
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotel(@PathVariable String hotelId) {

		List<Rating> rating1 = ratingService.getAllRatingOfHotel(hotelId);

		return new ResponseEntity<List<Rating>>(rating1, HttpStatus.ACCEPTED);
	}

}

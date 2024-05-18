package com.lcwd.user.service.UserService.impl;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFound;
import com.lcwd.user.service.UserService.external.service.HotelService;
import com.lcwd.user.service.UserService.repository.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;
	
	@Override
	public User saveUser(User user) {

		String uuid = UUID.randomUUID().toString();
		
		user.setUId(uuid);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String uId) {
		// TODO Auto-generated method stub
		
		User user = userRepo.findById(uId).orElseThrow(() -> new ResourceNotFound("User with given id is not found on server"));
		
		String url = "http://RATING-SERVICE/ratings/users/"+uId;
		Rating[] ratings = restTemplate.getForObject(url,Rating[].class);
		
		List<Rating> list = Arrays.stream( ratings).toList();
		
//		String urlToFetchHotelDetails = "http://HOTEL-SERVICE/hotels/";
		
		List<Rating> ratingsWithHotels = list.stream().map((rating) -> { 
			
			// make api call to hotel service to get the hotel
					
//			ResponseEntity<Hotel> hotelRs = restTemplate.getForEntity(urlToFetchHotelDetails+rating.getHotelId(), Hotel.class);
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			rating.setHotel(hotel);
			
			return rating;
			
		} ).collect(Collectors.toList());
		
		user.setRating(ratingsWithHotels);
		return user;
	}

}

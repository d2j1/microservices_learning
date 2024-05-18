package com.lcwd.user.service.UserService.controller;

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

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserContoller {

	@Autowired
	private UserService userService ;
	
	// create 
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		
		return new ResponseEntity<>(user1, HttpStatus.CREATED);
	}
	
	// single user get
	@GetMapping("/{userid}")
//	@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name="ratingHotelRetryService" , fallbackMethod = "ratingHotelFallback")
	@RateLimiter( name="userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String userid){
		
		User user1 = userService.getUser(userid);
		return new ResponseEntity<User>(user1, HttpStatus.ACCEPTED);
	}
	
	// fall back method 
	public ResponseEntity<User> ratingHotelFallback( String userId, Exception ex ){
		System.out.println("Fall back is executed because service is down :" + ex.getMessage());
		
		User user = User.
		builder().
		email("dummy@gmail.com").
		name("Dummy").
		about("This is dummy user created, because service is down").
		uId("12451").
		build();
		
		return new ResponseEntity<User>( user, HttpStatus.OK );
	}
	// all user get 
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> user1 = userService.getAllUser();
		return new ResponseEntity<>(user1, HttpStatus.ACCEPTED);
	}
	
}

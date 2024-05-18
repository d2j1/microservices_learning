package com.lcwd.user.service.UserService.entities;


import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {


	private String ratingId;
	
	private String userId;
	private String hotelId;
	
	private int rating;
	private String feedback;
	
	private Hotel hotel;
	
}

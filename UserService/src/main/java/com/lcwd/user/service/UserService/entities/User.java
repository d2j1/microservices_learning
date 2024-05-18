package com.lcwd.user.service.UserService.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@Column(name="uId")
	private String uId;
	
	private String name;
	private String email;
	private String about;
	
	  @Transient
	private List<Rating> rating;
	
	
	
	
	
}

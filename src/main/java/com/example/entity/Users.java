package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@NotEmpty(message = "Please enter your First Name")
	private String firstName;
	
	@NotEmpty(message = "Please enter your last Name")
	private String lastName;
	
	@NotEmpty(message = "Please enter your Email")
	private String email;
	
	@Size(min=10, max=10, message="Phone No should be 10 digits long")
	private String mobile;
	
	@Size(min=4, max=15, message="username lengtha should be in range of 4 to 15")
	@Pattern(regexp="^[A-Za-z0-9]*$",
			 message="Username has to be character and digits only with length of 4 to 15")
	private String userName;
	
	@Size(min=8, max=15, message="password length should be in range of 8 to 15")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,15}$",
			message="Password has to be 8 to 15 in length with mix of at least 1 upper,lower, 1 digit and 1 special character")
	private String password;
	
	private boolean isLoggedIn=false;
}

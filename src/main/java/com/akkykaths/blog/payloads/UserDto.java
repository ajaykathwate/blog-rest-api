package com.akkykaths.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4, message= "User name must be of atleast 4 characters!")
	private String name;
	
	@Email(message="Email address is not valid!!")
	private String email;
	
	@NotEmpty(message="Password must not be empty!")
	@Size(min = 6, max = 15, message= "Password must be 6 to 15 characters")
	private String password;
	
	@NotEmpty(message="About must not be empty!")
	private String about;
}

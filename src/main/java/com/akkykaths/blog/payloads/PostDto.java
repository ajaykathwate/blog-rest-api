package com.akkykaths.blog.payloads;

import com.akkykaths.blog.entities.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	private Integer postId;
	 
	@NotEmpty(message= "Title is Required !")
	@Size(min = 10, max = 100, message = "Title length must be between 10 to 100 chars.")
	private String title;
	
	@NotEmpty(message="Content required !")
	@Size(min = 50, max = 100000, message = "Title length must be atleast 50 chars.")
	private String content;
	
	@NotEmpty(message = "Image url is required !")
	private String imageName;
	
	private Date addedDate;
	
	private Date updatedAt;
	
	private UserDto user;
	
	private CategoryDto category;
	
	private Set<Comment> comments = new HashSet<>();
}

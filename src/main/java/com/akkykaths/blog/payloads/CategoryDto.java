package com.akkykaths.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;
	
	@Size(min=4, max=25, message= "title must be of atleast 4 characters!")
	@NotEmpty(message="Category title required!")
	private String categoryTitle;
	
	@NotEmpty(message="Category description required!")
	@Size(min=4, max=300, message= "Description must be of atleast 10 characters!")
	private String categoryDesc;

}

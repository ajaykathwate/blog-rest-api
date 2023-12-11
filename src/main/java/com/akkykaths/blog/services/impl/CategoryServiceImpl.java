package com.akkykaths.blog.services.impl;

import com.akkykaths.blog.entities.Category;
import com.akkykaths.blog.exceptions.ResourseNotFoundException;
import com.akkykaths.blog.payloads.CategoryDto;
import com.akkykaths.blog.repositories.CategoryRepo;
import com.akkykaths.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourseNotFoundException("Category", "category id", categoryId));
		cat.setCategoryDesc(categoryDto.getCategoryDesc());
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		
		Category updated = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updated, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category", "category id", categoryId));
		this.categoryRepo.delete(cat);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category", "category id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
		
		
		
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;		
	}

}

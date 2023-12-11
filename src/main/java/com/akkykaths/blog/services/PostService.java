package com.akkykaths.blog.services;

import java.util.List;

import com.akkykaths.blog.payloads.PostDto;
import com.akkykaths.blog.payloads.PostResponse;

public interface PostService {

	// create post
	PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);

	// update a post
	PostDto updatePost(PostDto postDto, Integer postId);

	// get a single post
	PostDto getPost(Integer postId);

	// delete post
	void deletePost(Integer postId);

	// get all posts
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// get all posts by category
	List<PostDto> getAllPostsByCategory(Integer categoryId);

	// get all posts by user
	List<PostDto> getAllPostsByUser(Integer userId);

	// search posts by keyword
	List<PostDto> searchPosts(String keyword);

}

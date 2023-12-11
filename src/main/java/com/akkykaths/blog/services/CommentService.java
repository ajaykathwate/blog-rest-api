package com.akkykaths.blog.services;

import com.akkykaths.blog.entities.CommentData;
import com.akkykaths.blog.payloads.CommentDto;

import java.util.List;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
	
	void deleteComment(Integer commentId);

	CommentData getAllComments(Integer postId);

}

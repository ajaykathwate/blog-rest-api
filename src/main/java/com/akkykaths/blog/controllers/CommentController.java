package com.akkykaths.blog.controllers;

import com.akkykaths.blog.entities.CommentData;
import com.akkykaths.blog.payloads.ApiResponse;
import com.akkykaths.blog.payloads.CommentDto;
import com.akkykaths.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@PostMapping("/post/{postId}/comments/user/{userId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,  @PathVariable Integer userId, @PathVariable Integer postId){
		CommentDto createdComment = this.commentService.createComment(commentDto, postId, userId);
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !!", true), HttpStatus.OK);
	}

	// post, user, comment
	@GetMapping("/comments/{postId}")
	public ResponseEntity<CommentData> getAllCommentsForPosts(@PathVariable Integer postId){
		CommentData comments = this.commentService.getAllComments(postId);
		return new ResponseEntity<CommentData>(comments, HttpStatus.OK);
	}
	
}

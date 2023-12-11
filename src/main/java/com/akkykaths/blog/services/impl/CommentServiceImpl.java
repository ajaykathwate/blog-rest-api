package com.akkykaths.blog.services.impl;

import com.akkykaths.blog.entities.Comment;
import com.akkykaths.blog.entities.CommentData;
import com.akkykaths.blog.entities.Post;
import com.akkykaths.blog.entities.User;
import com.akkykaths.blog.exceptions.ResourseNotFoundException;
import com.akkykaths.blog.payloads.CommentDto;
import com.akkykaths.blog.repositories.CommentRepo;
import com.akkykaths.blog.repositories.PostRepo;
import com.akkykaths.blog.repositories.UserRepo;
import com.akkykaths.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourseNotFoundException("Post", "postId", postId));

		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User","userId", userId));
		
		 Comment comment = this.modelMapper.map(commentDto, Comment.class);
		 
		 comment.setPost(post);

		 comment.setCommentor(user.getName());

		 Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourseNotFoundException("Comment", "commentId", commentId));
		this.commentRepo.delete(comment);

	}

	// comment , post, user
	@Override
	public CommentData getAllComments(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourseNotFoundException("Post", "postId", postId));
		String author = post.getUser().getName();

		Set<Comment> allComments = post.getComments();

		CommentData comments = new CommentData();
		comments.setAuthor(author);
		comments.setComments(allComments);

		return comments;
	}

}

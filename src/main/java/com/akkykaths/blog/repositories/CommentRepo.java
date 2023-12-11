package com.akkykaths.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akkykaths.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}

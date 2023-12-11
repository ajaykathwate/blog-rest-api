package com.akkykaths.blog.repositories;

import com.akkykaths.blog.entities.Category;
import com.akkykaths.blog.entities.Post;
import com.akkykaths.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);


    List<Post> findByTitleContaining(String keyword);
}

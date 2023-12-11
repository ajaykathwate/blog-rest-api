package com.akkykaths.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ajay Kathwate - 12/8/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentData {

    private String  author;

    Set<Comment> comments = new HashSet<>();

}

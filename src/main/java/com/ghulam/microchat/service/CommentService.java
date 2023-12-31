package com.ghulam.microchat.service;

import com.ghulam.microchat.model.Comment;

import java.util.List;

public interface CommentService {
    Comment save(String userId, String postId, Comment comment);
    Comment findById(String commentId);
    Comment update(String commentId, Comment comment);
    void delete(String commentId);
    List<Comment> findAll();
}

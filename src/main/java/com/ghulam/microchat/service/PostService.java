package com.ghulam.microchat.service;

import com.ghulam.microchat.model.Post;

import java.util.List;

public interface PostService {
    Post save(String userId, Post post);
    Post findById(String postId);
    Post update(String postId, Post post);
    void delete(String postId);
    List<Post> findAll();
}

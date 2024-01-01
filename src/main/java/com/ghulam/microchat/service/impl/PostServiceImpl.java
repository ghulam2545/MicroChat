package com.ghulam.microchat.service.impl;

import com.ghulam.microchat.exception.PostNotFoundException;
import com.ghulam.microchat.model.Post;
import com.ghulam.microchat.repository.PostRepository;
import com.ghulam.microchat.service.PostService;
import com.ghulam.microchat.service.UserService;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Post save(String userId, Post post) {
        post.setPostId(IdGenerator.next());
        post.setUser(userService.findById(userId));

        return postRepository.save(post);
    }

    @Override
    public Post findById(String postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("post not found."));
    }

    @Override
    public Post update(String postId, Post post) {
        return postRepository.findById(postId).map(oldPost -> {

            // update data
            oldPost.setContent(post.getContent());
            oldPost.setMediaUrl(post.getMediaUrl());
            oldPost.setLastUpdate(LocalDateTime.now());

            return postRepository.save(oldPost);
        }).orElseThrow(() -> new PostNotFoundException("post not found."));
    }

    @Override
    public void delete(String postId) {
        postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("post not found."));

        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> findAll() {
        /* todo - implement pagination etc */
        return postRepository.findAll();
    }
}

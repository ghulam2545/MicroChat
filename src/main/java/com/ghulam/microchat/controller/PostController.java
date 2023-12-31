package com.ghulam.microchat.controller;

import com.ghulam.microchat.converter.PostRequestToPost;
import com.ghulam.microchat.converter.PostToPostResponse;
import com.ghulam.microchat.dto.request.PostRequest;
import com.ghulam.microchat.dto.response.PostResponse;
import com.ghulam.microchat.model.Post;
import com.ghulam.microchat.service.PostService;
import com.ghulam.microchat.utils.Result;
import com.ghulam.microchat.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${api.endpoints.base-url}/posts")
@CrossOrigin("*")
public class PostController {

    private final PostService postService;
    private final PostRequestToPost postRequestToPost;
    private final PostToPostResponse postToPostResponse;

    @PostMapping
    public Result addPost(@RequestBody PostRequest postRequest) {
        final String userId = postRequest.userId();

        Post post = postRequestToPost.convert(postRequest);
        Post saved = postService.save(userId, post);

        PostResponse postResponse = postToPostResponse.convert(saved);
        return new Result(true, StatusCode.SUCCESS, "message - addPost", postResponse);
    }

    @GetMapping("/{postId}")
    public Result getPostById(@PathVariable String postId) {
        Post user = postService.findById(postId);

        PostResponse postResponse = postToPostResponse.convert(user);
        return new Result(true, StatusCode.SUCCESS, "message - getPostById", postResponse);
    }

    @PutMapping("/{postId}")
    public Result updatePost(@PathVariable String postId, @RequestBody PostRequest postRequest) {
        Post post = postRequestToPost.convert(postRequest);
        Post updatedPost = postService.update(postId, post);

        PostResponse updatedPostResponse = postToPostResponse.convert(updatedPost);
        return new Result(true, StatusCode.SUCCESS, "message - updatePost", updatedPostResponse);
    }

    @DeleteMapping("/{postId}")
    public Result deletePost(@PathVariable String postId) {
        postService.delete(postId);

        return new Result(true, StatusCode.SUCCESS, "message - deletePost");
    }

    @GetMapping
    public Result getAllPost() {
        List<PostResponse> result = postService.findAll()
                .stream().map(postToPostResponse::convert).toList();

        return new Result(true, StatusCode.SUCCESS, "message - getAllPost", result);
    }

}

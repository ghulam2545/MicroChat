package com.ghulam.microchat.controller;

import com.ghulam.microchat.converter.CommentRequestToComment;
import com.ghulam.microchat.converter.CommentToCommentResponse;
import com.ghulam.microchat.dto.request.CommentRequest;
import com.ghulam.microchat.dto.response.CommentResponse;
import com.ghulam.microchat.model.Comment;
import com.ghulam.microchat.service.CommentService;
import com.ghulam.microchat.utils.Result;
import com.ghulam.microchat.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${api.endpoints.base-url}/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentRequestToComment commentRequestToComment;
    private final CommentToCommentResponse commentToCommentResponse;

    @PostMapping
    public Result addComment(@RequestBody CommentRequest commentRequest) {
        final String userId = commentRequest.userId();
        final String postId = commentRequest.postId();

        Comment comment = commentRequestToComment.convert(commentRequest);
        Comment saved = commentService.save(userId, postId, comment);

        CommentResponse commentResponse = commentToCommentResponse.convert(saved);
        return new Result(true, StatusCode.SUCCESS, "message - addComment", commentResponse);
    }

    @GetMapping("/{commentId}")
    public Result getCommentById(@PathVariable String commentId) {
        Comment comment = commentService.findById(commentId);

        CommentResponse commentResponse = commentToCommentResponse.convert(comment);
        return new Result(true, StatusCode.SUCCESS, "message - getCommentById", commentResponse);
    }

    @PutMapping("/{commentId}")
    public Result updateComment(@PathVariable String commentId, @RequestBody CommentRequest commentRequest) {
        Comment comment = commentRequestToComment.convert(commentRequest);
        Comment updatedComment = commentService.update(commentId, comment);

        CommentResponse updatedCommentResponse = commentToCommentResponse.convert(updatedComment);
        return new Result(true, StatusCode.SUCCESS, "message - updateComment", updatedCommentResponse);
    }

    @DeleteMapping("/{commentId}")
    public Result deleteComment(@PathVariable String commentId) {
        commentService.delete(commentId);

        return new Result(true, StatusCode.SUCCESS, "message - deleteComment");
    }

    @GetMapping
    public Result getAllComment() {
        List<CommentResponse> result = commentService.findAll()
                .stream().map(commentToCommentResponse::convert).toList();

        return new Result(true, StatusCode.SUCCESS, "message - getAllComment", result);
    }

}

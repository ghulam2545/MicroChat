package com.ghulam.mitter.controller;

import com.ghulam.mitter.converter.CommentDtoToComment;
import com.ghulam.mitter.converter.CommentToCommentDto;
import com.ghulam.mitter.domain.Comment;
import com.ghulam.mitter.dto.CommentDto;
import com.ghulam.mitter.service.CommentService;
import com.ghulam.mitter.system.Result;
import com.ghulam.mitter.system.StatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentToCommentDto commentToCommentDto;
    private final CommentDtoToComment commentDtoToComment;

    public CommentController(CommentService commentService, CommentToCommentDto commentToCommentDto, CommentDtoToComment commentDtoToComment) {
        this.commentService = commentService;
        this.commentToCommentDto = commentToCommentDto;
        this.commentDtoToComment = commentDtoToComment;
    }

    @PostMapping("/{tweetId}")
    public Result addComment(@PathVariable String tweetId, @RequestBody CommentDto commentDto) {
        // todo
        Comment comment = commentDtoToComment.convert(commentDto);
        Comment savedComment = commentService.save(comment);
        CommentDto savedCommentDto = commentToCommentDto.convert(savedComment);
        return new Result(true, StatusCode.SUCCESS, "message - addComment", savedCommentDto);
    }

    @GetMapping("/{commentId}")
    public Result getCommentById(@PathVariable String commentId) {
        Comment comment = commentService.findById(commentId);
        CommentDto commentDto = commentToCommentDto.convert(comment);
        return new Result(true, StatusCode.SUCCESS, "message - getCommentById", commentDto);
    }

    @PutMapping("/{commentId}")
    public Result updateComment(@PathVariable String commentId, @RequestBody CommentDto commentDto) {
        Comment comment = commentDtoToComment.convert(commentDto);
        Comment updatedComment = commentService.update(commentId, comment);
        CommentDto updatedCommentDto = commentToCommentDto.convert(updatedComment);
        return new Result(true, StatusCode.SUCCESS, "message - updateComment", updatedCommentDto);
    }

    @DeleteMapping("/{commentId}")
    public Result deleteComment(@PathVariable String commentId) {
        commentService.delete(commentId);
        return new Result(true, StatusCode.SUCCESS, "message - deleteComment");
    }

    @GetMapping
    public List<Comment> getAllComment() {
        // todo
        return null;
    }
}

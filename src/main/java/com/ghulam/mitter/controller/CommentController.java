package com.ghulam.mitter.controller;

import com.ghulam.mitter.converter.CommentRequestDtoToComment;
import com.ghulam.mitter.converter.CommentToCommentResponseDto;
import com.ghulam.mitter.domain.Comment;
import com.ghulam.mitter.dto.request.CommentRequestDto;
import com.ghulam.mitter.dto.response.CommentResponseDto;
import com.ghulam.mitter.service.CommentService;
import com.ghulam.mitter.system.Result;
import com.ghulam.mitter.system.StatusCode;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentRequestDtoToComment commentRequestDtoToComment;
    private final CommentToCommentResponseDto commentToCommentResponseDto;

    public CommentController(CommentService commentService,
                             CommentRequestDtoToComment commentRequestDtoToComment,
                             CommentToCommentResponseDto commentToCommentResponseDto) {

        this.commentService = commentService;
        this.commentRequestDtoToComment = commentRequestDtoToComment;
        this.commentToCommentResponseDto = commentToCommentResponseDto;
    }

    @PostMapping
    public Result addComment(@RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = commentRequestDtoToComment.convert(commentRequestDto);
        Comment savedComment = commentService.save(comment);
        CommentResponseDto savedCommentResponseDto = commentToCommentResponseDto.convert(savedComment);
        return new Result(true, StatusCode.SUCCESS, "message - addComment", savedCommentResponseDto);
    }

    @GetMapping("/{commentId}")
    public Result getCommentById(@PathVariable String commentId) {
        Comment comment = commentService.findById(commentId);
        CommentResponseDto commentResponseDto = commentToCommentResponseDto.convert(comment);
        return new Result(true, StatusCode.SUCCESS, "message - getCommentById", commentResponseDto);
    }

    @PutMapping("/{commentId}")
    public Result updateComment(@PathVariable String commentId, @RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = commentRequestDtoToComment.convert(commentRequestDto);
        Comment updatedComment = commentService.update(commentId, comment);
        CommentResponseDto updatedCommentResponseDto = commentToCommentResponseDto.convert(updatedComment);
        return new Result(true, StatusCode.SUCCESS, "message - updateComment", updatedCommentResponseDto);
    }

    @DeleteMapping("/{commentId}")
    public Result deleteComment(@PathVariable String commentId) {
        commentService.delete(commentId);
        return new Result(true, StatusCode.SUCCESS, "message - deleteComment");
    }

    @GetMapping
    public Result getAllComment() {
        List<Comment> allComment = commentService.findAll();

        // todo
        return new Result(true, StatusCode.SUCCESS, "message - getAllComment", allComment);
    }
}

package com.ghulam.mitter.dto.request;

public record CommentRequestDto(
        String content,
        String userId,
        String commentId
) {
}

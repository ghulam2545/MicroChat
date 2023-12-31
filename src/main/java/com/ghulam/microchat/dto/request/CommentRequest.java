package com.ghulam.microchat.dto.request;

public record CommentRequest(
        String content,
        String userId,
        String postId
) {
}

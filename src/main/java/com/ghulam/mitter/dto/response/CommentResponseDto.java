package com.ghulam.mitter.dto.response;

import java.time.LocalDateTime;

public record CommentResponseDto(
        String commentId,
        String content,
        LocalDateTime timestamp,
        String userId,
        String tweetId
) {
}

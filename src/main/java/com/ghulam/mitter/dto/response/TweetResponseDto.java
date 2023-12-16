package com.ghulam.mitter.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record TweetResponseDto(
        String tweetId,
        String content,
        String mediaUrl,
        LocalDateTime timestamp,
        String hashtags,
        String userId,
        List<String> commentIds
) {
}

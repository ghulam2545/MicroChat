package com.ghulam.mitter.dto.request;

public record TweetRequestDto(
        String content,
        String mediaUrl,
        String hashtags,
        String userId
) {
}

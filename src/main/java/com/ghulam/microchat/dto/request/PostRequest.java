package com.ghulam.microchat.dto.request;

public record PostRequest(
        String content,
        String mediaUrl,
        String userId
) {
}

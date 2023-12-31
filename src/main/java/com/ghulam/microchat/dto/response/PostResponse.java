package com.ghulam.microchat.dto.response;

import java.time.LocalDateTime;

public record PostResponse(
        String postId,
        String content,
        String mediaUrl,
        LocalDateTime lastUpdate
) {
}

package com.ghulam.mitter.dto.response;

import java.util.List;

public record UserResponseDto(
        String userId,
        String username,
        String email,
        String fullname,
        String description,
        String country,
        String imageUrl,
        List<String> tweetIds,
        List<String> commentIds
) {
}

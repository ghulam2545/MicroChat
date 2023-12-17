package com.ghulam.mitter.dto.response;

public record UserResponseDto(
        String userId,
        String username,
        String email,
        String fullname,
        String description,
        String country,
        String imageUrl
) {
}

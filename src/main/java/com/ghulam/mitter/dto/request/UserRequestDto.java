package com.ghulam.mitter.dto.request;

public record UserRequestDto(
        String username,
        String email,
        String password,
        String fullname,
        String description,
        String country,
        String imageUrl
) {
}

package com.ghulam.microchat.dto.response;

public record UserResponse(
        String userId,
        String firstName,
        String lastName,
        String username,
        String password,
        String country,
        LinkResponse linkResponse
) {
}

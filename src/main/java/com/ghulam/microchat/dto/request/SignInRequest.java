package com.ghulam.microchat.dto.request;

public record SignInRequest(
        String email,
        String password
) {
}

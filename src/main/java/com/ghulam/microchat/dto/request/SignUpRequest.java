package com.ghulam.microchat.dto.request;

public record SignUpRequest (
        String fullname,
        String password,
        String email
) {
}

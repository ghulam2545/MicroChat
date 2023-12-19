package com.ghulam.microchat.dto.request;

public record UserRequest (
        String fullname,
        String password,
        String email
) {
}

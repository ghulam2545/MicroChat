package com.ghulam.microchat.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(

        @NotEmpty(message = "username could not be empty.")
        String username,

        @NotEmpty(message = "password could not be empty.")
        String password
) {
}

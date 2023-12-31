package com.ghulam.microchat.dto.response;

import jakarta.validation.constraints.NotEmpty;

public record ResultToken(
        @NotEmpty(message = "token could not be empty.")
        String token
) {
}

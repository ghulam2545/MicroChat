package com.ghulam.microchat.dto.request;

import com.ghulam.microchat.dto.request.LinksRequest;

public record SignupRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        String country,
        LinksRequest linksRequest
) {
}

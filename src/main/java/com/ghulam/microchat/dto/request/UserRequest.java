package com.ghulam.microchat.dto.request;

public record UserRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        String country,
        LinksRequest linksRequest
) {
}

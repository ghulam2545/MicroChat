package com.ghulam.mitter.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String username;
    private String email;
    private String fullname;
    private String description;
    private String country;
    private String imageUrl;
}

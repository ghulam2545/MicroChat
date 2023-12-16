package com.ghulam.mitter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String fullname;
    private String description;
    private String country;
    private String imageUrl;
}

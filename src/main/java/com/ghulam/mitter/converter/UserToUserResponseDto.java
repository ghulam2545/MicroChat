package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.dto.response.UserResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserToUserResponseDto implements Converter<User, UserResponseDto> {
    @Override
    public UserResponseDto convert(User source) {
        UserResponseDto dto = new UserResponseDto();

        dto.setUsername(source.getUsername());
        dto.setEmail(source.getEmail());
        dto.setFullname(source.getFullname());
        dto.setDescription(source.getDescription());
        dto.setCountry(source.getCountry());
        dto.setImageUrl(source.getImageUrl());

        return dto;
    }
}

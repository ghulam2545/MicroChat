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
        return new UserResponseDto(
                source.getUserId(),
                source.getUsername(),
                source.getEmail(),
                source.getFullname(),
                source.getDescription(),
                source.getCountry(),
                source.getImageUrl()
        );
    }
}

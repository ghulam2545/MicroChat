package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User source) {
        UserDto userDto = new UserDto();

        userDto.setUsername(source.getUsername());
        userDto.setEmail(source.getEmail());
        userDto.setPassword(source.getPassword());
        userDto.setFullname(source.getFullname());
        userDto.setDescription(source.getDescription());
        userDto.setCountry(source.getCountry());
        userDto.setImageUrl(source.getImageUrl());

        return userDto;
    }
}

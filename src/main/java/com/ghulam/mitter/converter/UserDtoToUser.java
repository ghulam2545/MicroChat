package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto source) {
        User user = new User();

        user.setUsername(source.getUsername());
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        user.setFullname(source.getFullname());
        user.setDescription(source.getDescription());
        user.setCountry(source.getCountry());
        user.setImageUrl(source.getImageUrl());

        return user;
    }
}

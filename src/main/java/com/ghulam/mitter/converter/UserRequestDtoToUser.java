package com.ghulam.mitter.converter;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.dto.request.UserRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserRequestDtoToUser implements Converter<UserRequestDto, User> {
    @Override
    public User convert(UserRequestDto source) {
        User user = new User();

        user.setUsername(source.username());
        user.setEmail(source.email());
        user.setPassword(source.password());
        user.setFullname(source.fullname());
        user.setDescription(source.description());
        user.setCountry(source.country());
        user.setImageUrl(source.imageUrl());

        return user;
    }
}

package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.request.UserRequest;
import com.ghulam.microchat.model.User;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserRequestToUser implements Converter<UserRequest, User> {
    @Override
    public User convert(UserRequest source) {
        User user = new User();

        user.setFullname(source.fullname());
        user.setEmail(source.email());
        user.setPassword(source.password());

        return user;
    }
}

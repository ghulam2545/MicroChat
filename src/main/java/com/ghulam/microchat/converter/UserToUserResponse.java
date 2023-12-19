package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.response.UserResponse;
import com.ghulam.microchat.model.User;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserToUserResponse implements Converter<User, UserResponse> {
    @Override
    public UserResponse convert(User source) {
        return new UserResponse(
                source.getId(),
                source.getFullname(),
                source.getEmail()
        );
    }
}

package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.response.UserResponse;
import com.ghulam.microchat.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserToUserResponse implements Converter<User, UserResponse> {

    private final LinksToLinksResponse linksToLinksResponse;

    @Override
    public UserResponse convert(User source) {
        return new UserResponse(
                source.getUserId(),
                source.getFirstName(),
                source.getLastName(),
                source.getUsername(),
                source.getPassword(),
                source.getCountry(),
                linksToLinksResponse.convert(source.getLinks())
        );
    }
}

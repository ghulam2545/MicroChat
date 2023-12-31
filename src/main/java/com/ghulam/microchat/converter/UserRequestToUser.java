package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.request.UserRequest;
import com.ghulam.microchat.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserRequestToUser implements Converter<UserRequest, User> {

    private final LinksRequestToLinks linksRequestToLinks;

    @Override
    public User convert(UserRequest source) {

        User user = new User();

        user.setFirstName(source.firstName());
        user.setLastName(source.lastName());
        user.setUsername(source.username());
        user.setPassword(source.password());
        user.setCountry(source.country());
        user.setLinks(linksRequestToLinks.convert(source.linksRequest()));

        return user;
    }
}

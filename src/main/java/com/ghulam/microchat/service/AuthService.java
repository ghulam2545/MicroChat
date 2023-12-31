package com.ghulam.microchat.service;

import com.ghulam.microchat.converter.LinksRequestToLinks;
import com.ghulam.microchat.dto.request.LoginRequest;
import com.ghulam.microchat.dto.response.ResultToken;
import com.ghulam.microchat.dto.request.SignupRequest;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.model.UserPrinciple;
import com.ghulam.microchat.repository.UserRepository;
import com.ghulam.microchat.security.JwtService;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final LinksRequestToLinks linksRequestToLinks;


    public ResultToken register(SignupRequest request) {
        // save user
        User user = new User();
        user.setUserId(IdGenerator.next());
        user.setRole("ROLE_USER");
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setCountry(request.country());
        user.setLinks(linksRequestToLinks.convert(request.linksRequest()));

        userRepository.save(user);

        // generate token
        String token = jwtService.generateToken(new UserPrinciple(user));
        return new ResultToken(token);
    }


    public ResultToken login(LoginRequest request) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid username/password supplied");
        }

        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // generate token
        String token = jwtService.generateToken(new UserPrinciple(user));
        return new ResultToken(token);
    }

}

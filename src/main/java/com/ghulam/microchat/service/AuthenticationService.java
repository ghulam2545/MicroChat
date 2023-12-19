package com.ghulam.microchat.service;

import com.ghulam.microchat.config.JwtService;
import com.ghulam.microchat.dto.request.SignInRequest;
import com.ghulam.microchat.dto.request.SignUpRequest;
import com.ghulam.microchat.dto.response.JwtAuthenticationResponse;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthenticationResponse signup(SignUpRequest request) {
        User user = User.builder()
                .fullname(request.fullname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
        userService.save(user);

        String token = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(token).build();
    }

    public JwtAuthenticationResponse signin(SignInRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid username/password supplied");
        }

        User user = userRepository.findByEmail(request.email()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(token).build();
    }
}

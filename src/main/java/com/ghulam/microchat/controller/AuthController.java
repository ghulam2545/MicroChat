package com.ghulam.microchat.controller;

import com.ghulam.microchat.dto.request.SignInRequest;
import com.ghulam.microchat.dto.request.SignUpRequest;
import com.ghulam.microchat.dto.response.JwtAuthenticationResponse;
import com.ghulam.microchat.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public JwtAuthenticationResponse signup(@RequestBody SignUpRequest request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.signin(request);
    }
}

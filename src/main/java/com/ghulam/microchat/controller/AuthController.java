package com.ghulam.microchat.controller;

import com.ghulam.microchat.dto.request.LoginRequest;
import com.ghulam.microchat.dto.request.SignupRequest;
import com.ghulam.microchat.dto.response.ResultToken;
import com.ghulam.microchat.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${api.endpoints.base-url}")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResultToken register(@RequestBody SignupRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResultToken login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}

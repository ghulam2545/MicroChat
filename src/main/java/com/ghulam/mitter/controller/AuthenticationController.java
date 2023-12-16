package com.ghulam.mitter.controller;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.service.UserService;
import com.ghulam.mitter.system.Result;
import com.ghulam.mitter.system.StatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private final UserService userService;
    private final UserToUserDto userToUserDto;
    private final UserDtoToUser userDtoToUser;

    public AuthenticationController(UserService userService, UserToUserDto userToUserDto, UserDtoToUser userDtoToUser) {
        this.userService = userService;
        this.userToUserDto = userToUserDto;
        this.userDtoToUser = userDtoToUser;
    }

    @PostMapping("/register")
    public Result registerUser(@RequestBody UserDto userDto) {
        User user = userDtoToUser.convert(userDto);
        User savedUser = userService.save(user);
        UserDto savedUserDto = userToUserDto.convert(savedUser);
        return new Result(true, StatusCode.SUCCESS, "message - registerUser", savedUserDto);
    }

    public Result loginUser() {
        return null;
    }

    public Result logoutUser() {
        return null;
    }
}

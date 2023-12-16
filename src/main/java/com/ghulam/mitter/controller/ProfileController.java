package com.ghulam.mitter.controller;

import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.service.UserService;
import com.ghulam.mitter.system.Result;
import com.ghulam.mitter.system.StatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final UserService userService;
    private final UserToUserDto userToUserDto;
    private final UserDtoToUser userDtoToUser;

    public ProfileController(UserService userService, UserToUserDto userToUserDto, UserDtoToUser userDtoToUser) {
        this.userService = userService;
        this.userToUserDto = userToUserDto;
        this.userDtoToUser = userDtoToUser;
    }

    @GetMapping("/{userId}")
    public Result getUserById(@PathVariable String userId) {
        User user = userService.findById(userId);
        UserDto userDto = userToUserDto.convert(user);
        return new Result(true, StatusCode.SUCCESS, "message - getUserById", userDto);
    }

    @PutMapping("/{userId}")
    public Result updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        User user = userDtoToUser.convert(userDto);
        User updatedUser = userService.update(userId, user);
        UserDto updatedUserDto = userToUserDto.convert(updatedUser);
        return new Result(true, StatusCode.SUCCESS, "message - updateUser", updatedUserDto);
    }

    @DeleteMapping("/{userId}")
    public Result deleteUser(@PathVariable String userId) {
        userService.delete(userId);
        return new Result(true, StatusCode.SUCCESS, "message - deleteUser");
    }
}

package com.ghulam.microchat.controller;

import com.ghulam.microchat.converter.UserRequestToUser;
import com.ghulam.microchat.converter.UserToUserResponse;
import com.ghulam.microchat.dto.request.UserRequest;
import com.ghulam.microchat.dto.response.UserResponse;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.service.UserService;
import com.ghulam.microchat.utils.Result;
import com.ghulam.microchat.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${api.endpoints.base-url}/users")
public class UserController {

    private final UserService userService;
    private final UserRequestToUser userRequestToUser;
    private final UserToUserResponse userToUserResponse;

    @PostMapping
    public Result addUser(@RequestBody UserRequest userRequest) {
        User user = userRequestToUser.convert(userRequest);
        User saved = userService.save(user);

        UserResponse userResponseDto = userToUserResponse.convert(saved);
        return new Result(true, StatusCode.SUCCESS, "message - addUser", userResponseDto);
    }

    @GetMapping("/{userId}")
    public Result getUserById(@PathVariable String userId) {
        User user = userService.findById(userId);

        UserResponse userResponseDto = userToUserResponse.convert(user);
        return new Result(true, StatusCode.SUCCESS, "message - getUserById", userResponseDto);
    }

    @PutMapping("/{userId}")
    public Result updateUser(@PathVariable String userId, @RequestBody UserRequest userRequest) {
        User user = userRequestToUser.convert(userRequest);
        User updatedUser = userService.update(userId, user);

        UserResponse updatedUserResponseDto = userToUserResponse.convert(updatedUser);
        return new Result(true, StatusCode.SUCCESS, "message - updateUser", updatedUserResponseDto);
    }

    @DeleteMapping("/{userId}")
    public Result deleteUser(@PathVariable String userId) {
        userService.delete(userId);

        return new Result(true, StatusCode.SUCCESS, "message - deleteUser");
    }

    @GetMapping
    public Result getAllUser() {
        List<UserResponse> result = userService.findAll()
                .stream().map(userToUserResponse::convert).toList();

        return new Result(true, StatusCode.SUCCESS, "message - getAllUser", result);
    }

}

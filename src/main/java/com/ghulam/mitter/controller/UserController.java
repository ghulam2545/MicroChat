package com.ghulam.mitter.controller;

import com.ghulam.mitter.converter.UserDtoToUser;
import com.ghulam.mitter.converter.UserToUserDto;
import com.ghulam.mitter.domain.User;
import com.ghulam.mitter.dto.UserDto;
import com.ghulam.mitter.service.UserService;
import com.ghulam.mitter.system.Result;
import com.ghulam.mitter.system.StatusCode;
import com.ghulam.mitter.utils.IdGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final IdGenerator idGenerator;
    private final UserToUserDto userToUserDto;
    private final UserDtoToUser userDtoToUser;

    public UserController(UserService userService, IdGenerator idGenerator, UserToUserDto userToUserDto, UserDtoToUser userDtoToUser) {
        this.userService = userService;
        this.idGenerator = idGenerator;
        this.userToUserDto = userToUserDto;
        this.userDtoToUser = userDtoToUser;
    }

    @PostMapping
    public Result addUser(@RequestBody UserDto userDto) {
        User user = userDtoToUser.convert(userDto);

        final long id = idGenerator.nextId();
        assert user != null;
        user.setUserId(id + "");

        User savedUser = userService.save(user);
        UserDto savedUserDto = userToUserDto.convert(savedUser);
        return new Result(true, StatusCode.SUCCESS, "message - addUser", savedUserDto);
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

    public Result getAllUser() {
        /* todo - implement pagination etc */
        return null;
    }
}

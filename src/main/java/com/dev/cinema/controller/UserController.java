package com.dev.cinema.controller;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.UserRequestDto;
import com.dev.cinema.model.dto.UserResponseDto;
import com.dev.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public void addUser(@RequestBody UserRequestDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userService.add(user);
    }

    @GetMapping(value = "/byemail")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email);
        UserResponseDto userDto = new UserResponseDto();
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}

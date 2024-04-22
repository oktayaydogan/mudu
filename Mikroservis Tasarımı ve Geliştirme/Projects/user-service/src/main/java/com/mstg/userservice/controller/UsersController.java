package com.mstg.userservice.controller;

import com.mstg.userservice.dto.LoginDto;
import com.mstg.userservice.model.Users;
import com.mstg.userservice.model.Users_Details;
import com.mstg.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*  TODO: to be implemented
*   Spring Security -> JWT (json web token)
* */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UsersController {
    private final Logger _logger = LoggerFactory.getLogger(UsersController.class);
    private final UserService _userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto dto) {
        boolean result = _userService.login(dto);

        if (result) {
            _logger.info("User logged in successfully.");
            return ResponseEntity.ok().build();
        }

        _logger.error("User login failed.");
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register() {
        Users demoUser = Users.builder()
                .username("demo")
                .password("demo")
                .detail(Users_Details.builder()
                        .age(35)
                        .gender("male")
                        .address("Bursa")
                        .build())
                .build();

        return ResponseEntity.ok().build();
    }
}

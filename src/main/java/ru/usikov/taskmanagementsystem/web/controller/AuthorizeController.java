package ru.usikov.taskmanagementsystem.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.usikov.taskmanagementsystem.service.AuthorizeService;
import ru.usikov.taskmanagementsystem.web.dto.user.ChangePasswordRequest;
import ru.usikov.taskmanagementsystem.web.dto.user.UserCreateRequest;
import ru.usikov.taskmanagementsystem.web.security.auth.JwtRequest;
import ru.usikov.taskmanagementsystem.web.security.auth.JwtResponse;

@RestController
@RequestMapping("/authorize")
@RequiredArgsConstructor
public class AuthorizeController {

    private final AuthorizeService authorizeService;

    @PostMapping("/register")
    public JwtResponse register(final UserCreateRequest userCreateRequest) {
        return authorizeService.register(userCreateRequest);
    }

    @PostMapping("/change-password")
    public JwtResponse changePassword(final ChangePasswordRequest changePasswordRequest) {
        return authorizeService.changePassword(changePasswordRequest);
    }

    @PostMapping("/login")
    public JwtResponse login(final JwtRequest loginRequest) {
        return authorizeService.login(loginRequest);
    }
}

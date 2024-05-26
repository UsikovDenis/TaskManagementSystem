package ru.usikov.taskmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.usikov.taskmanagementsystem.entities.user.User;
import ru.usikov.taskmanagementsystem.web.dto.user.ChangePasswordRequest;
import ru.usikov.taskmanagementsystem.web.dto.user.UserCreateRequest;
import ru.usikov.taskmanagementsystem.web.dto.user.UserDto;
import ru.usikov.taskmanagementsystem.web.security.JwtTokenProvider;
import ru.usikov.taskmanagementsystem.web.security.auth.JwtRequest;
import ru.usikov.taskmanagementsystem.web.security.auth.JwtResponse;

@Service
@RequiredArgsConstructor
public class AuthorizeService {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtResponse login(final JwtRequest request) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        authenticationManager.authenticate(authenticationToken);

        return getJwtResponse(userService.getByUsername(request.getUsername()));
    }

    public JwtResponse refresh(final String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }

    public JwtResponse register(UserCreateRequest userCreateRequest) {
        userCreateRequest.setPasswordHash(hashPassword(userCreateRequest.getPasswordHash()));
        UserDto user = userService.create(userCreateRequest);

        return getJwtResponse(user);
    }

    public JwtResponse changePassword(final ChangePasswordRequest changePasswordRequest) {
        String passwordHash = hashPassword(changePasswordRequest.getPassword());
        UserDto user = userService.changePassword(changePasswordRequest.getUsername(), passwordHash);

        return getJwtResponse(user);
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private JwtResponse getJwtResponse(UserDto user) {
        return JwtResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .accessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUsername(), user.getRoles()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()))
                .build();
    }

}

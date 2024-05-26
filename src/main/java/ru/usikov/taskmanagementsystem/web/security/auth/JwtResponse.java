package ru.usikov.taskmanagementsystem.web.security.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Schema(description = "Request after login")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private UUID id;
    private String username;
    private String accessToken;
    private String refreshToken;

}

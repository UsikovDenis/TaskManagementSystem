package ru.usikov.taskmanagementsystem.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Schema(description = "Модель пользователя")
public class UserDto {

    @Schema(description = "Идентификатор")
    private UUID id;

    @Schema(description = "Имя", example = "Denis")
    private String name;

    @Column(nullable = false)
    private String username;

    @Schema(description = "почта")
    private String email;

    @Schema(description = "пароль")
    private String password;

    @Schema(description = "Подтверждение пароля")
    private String passwordConfirmation;
}

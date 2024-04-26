package ru.usikov.taskmanagementsystem.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import ru.usikov.taskmanagementsystem.web.dto.validdation.OnCreate;
import ru.usikov.taskmanagementsystem.web.dto.validdation.OnUpdate;

import java.util.UUID;

@Getter
@Setter
@Schema(description = "Модель пользователя")
public class UserDto {

    @Schema(description = "Идентификатор")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private UUID id;

    @Schema(description = "Имя", example = "Denis")
    @NotNull(message = "Name must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255,
            message = "Name length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Schema(description = "фамилия")
    @Column(nullable = false)
    @NotNull(message = "Username must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255,
            message = "Username length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Schema(description = "почта")
    @NotNull(message = "Email must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255,
            message = "Email length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @Schema(description = "пароль")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @Schema(description = "Подтверждение пароля")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null.",
            groups = {OnCreate.class})
    private String passwordConfirmation;
}

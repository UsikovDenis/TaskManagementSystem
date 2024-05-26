package ru.usikov.taskmanagementsystem.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.usikov.taskmanagementsystem.web.dto.validdation.OnCreate;
import ru.usikov.taskmanagementsystem.web.dto.validdation.OnUpdate;

@Getter
@Setter
public class UserCreateRequest extends UserDto {

    @Schema(description = "пароль")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    private String passwordHash;
}

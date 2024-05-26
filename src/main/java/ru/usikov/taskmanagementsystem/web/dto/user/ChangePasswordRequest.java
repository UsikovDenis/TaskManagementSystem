package ru.usikov.taskmanagementsystem.web.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {

    private String username;
    private String password;

}

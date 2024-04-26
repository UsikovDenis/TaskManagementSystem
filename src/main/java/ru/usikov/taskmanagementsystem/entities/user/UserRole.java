package ru.usikov.taskmanagementsystem.entities.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserRole {

    ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN

}

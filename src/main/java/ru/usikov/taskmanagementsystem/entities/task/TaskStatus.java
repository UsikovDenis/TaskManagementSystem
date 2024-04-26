package ru.usikov.taskmanagementsystem.entities.task;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TaskStatus {

    WAITING("В ожидании"),
    PROCESS("В процессе"),
    COMPLETED("Завершено");

    private final String description;
}

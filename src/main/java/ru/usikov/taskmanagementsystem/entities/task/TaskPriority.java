package ru.usikov.taskmanagementsystem.entities.task;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TaskPriority {

    HIGH("высокий"),
    AVERAGE("средний"),
    LOW("низкий");

    private final String description;
}

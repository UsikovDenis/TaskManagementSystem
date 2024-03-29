package ru.usikov.taskmanagementsystem.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.usikov.taskmanagementsystem.entities.task.TaskPriority;
import ru.usikov.taskmanagementsystem.entities.task.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;



@Getter
@Setter
@Schema(description = "Модель задачи")
public class TaskDto {

    @Schema(description = "Идентификатор")
    private UUID id;

    @Schema(description = "Заголовок", example = "TЗ")
    private String title;

    @Schema(description = "Описание", example = "написать CRUD")
    private String description;

    @Schema(description = "Автор", example = "Denis")
    private UserDto author;

    @Schema(description = "Исполнитель", example = "Andrey")
    private UserDto executor;

    @Schema(description = "Статус")
    private TaskStatus status;

    @Schema(description = "Приоретет")
    private TaskPriority priority;

    @Schema(description = "Дата окончания срока")
    private LocalDateTime expirationDate;

    @Schema(description = "Дата создания")
    private LocalDateTime createDate;

    @Schema(description = "Дата изменения")
    private LocalDateTime updateDate;
}

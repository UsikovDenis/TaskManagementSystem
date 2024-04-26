package ru.usikov.taskmanagementsystem.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.usikov.taskmanagementsystem.entities.task.TaskPriority;
import ru.usikov.taskmanagementsystem.entities.task.TaskStatus;
import ru.usikov.taskmanagementsystem.web.dto.user.UserDto;
import ru.usikov.taskmanagementsystem.web.dto.validdation.OnCreate;
import ru.usikov.taskmanagementsystem.web.dto.validdation.OnUpdate;

import java.time.LocalDateTime;
import java.util.UUID;



@Getter
@Setter
@Schema(description = "Модель задачи")
public class TaskDto {

    @Schema(description = "Идентификатор")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private UUID id;

    @Schema(description = "Заголовок", example = "TЗ")
    @NotNull(message = "Title must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255,
            message = "Title length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Schema(description = "Описание", example = "написать CRUD")
    @Length(max = 255,
            message = "Description length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private String description;

    @Schema(description = "Автор", example = "Denis")
    @NotNull(message = "Author must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255,
            message = "Author length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private UserDto author;

    @Schema(description = "Исполнитель", example = "Andrey")
    @NotNull(message = "Executor must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255,
            message = "Executor length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private UserDto executor;

    @Schema(description = "Статус")
    private TaskStatus status;

    @Schema(description = "Приоретет")
    private TaskPriority priority;

    @Schema(description = "Дата окончания срока")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;

    @Schema(description = "Дата создания")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDate;

    @Schema(description = "Дата изменения")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateDate;
}

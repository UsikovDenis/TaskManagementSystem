package ru.usikov.taskmanagementsystem.web.mapper;

import org.mapstruct.Mapper;
import ru.usikov.taskmanagementsystem.entities.task.Task;
import ru.usikov.taskmanagementsystem.web.dto.TaskDto;

@Mapper
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}

package ru.usikov.taskmanagementsystem.mapper;

import org.mapstruct.Mapper;
import ru.usikov.taskmanagementsystem.domain.entities.Task;
import ru.usikov.taskmanagementsystem.dto.TaskDto;

@Mapper
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}

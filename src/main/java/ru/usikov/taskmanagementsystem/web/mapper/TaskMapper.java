package ru.usikov.taskmanagementsystem.web.mapper;

import org.mapstruct.Mapper;
import ru.usikov.taskmanagementsystem.entities.task.Task;
import ru.usikov.taskmanagementsystem.web.dto.task.TaskDto;

@Mapper
public interface TaskMapper extends Mappable<Task, TaskDto>  {
}

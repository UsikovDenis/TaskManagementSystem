package ru.usikov.taskmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.usikov.taskmanagementsystem.entities.task.Task;
import ru.usikov.taskmanagementsystem.repository.TaskRepository;
import ru.usikov.taskmanagementsystem.web.dto.task.TaskDto;
import ru.usikov.taskmanagementsystem.web.errors.NotFoundException;
import ru.usikov.taskmanagementsystem.web.mapper.TaskMapper;

import java.util.List;
import java.util.UUID;

import static ru.usikov.taskmanagementsystem.web.ApiMessageConstants.NOT_FOUND_TASK;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public TaskDto getTaskById(final UUID id) {
        final Task task = getById(id);
        return taskMapper.toDto(task);
    }

    @Transactional
    public UUID saveOrUpdate(final TaskDto taskDto) {
        return taskRepository.save(taskMapper.toEntity(taskDto)).getId();
    }

    @Transactional
    public void deleteTaskById(final UUID id) {
        taskRepository.delete(getById(id));
    }

    private Task getById(final UUID id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_TASK));
    }
}


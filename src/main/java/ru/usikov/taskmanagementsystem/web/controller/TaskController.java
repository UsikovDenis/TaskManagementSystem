package ru.usikov.taskmanagementsystem.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.usikov.taskmanagementsystem.web.dto.task.TaskDto;
import ru.usikov.taskmanagementsystem.service.TaskService;

import java.util.List;
import java.util.UUID;

import static ru.usikov.taskmanagementsystem.web.ApiMessageConstants.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
@Tag(name = "CRUD для задач", description = "— API для управления списком задач")
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Получить список всех задач")
    @ApiResponse(responseCode = SUCCESS, description = "Список задач", useReturnTypeSchema = true)
    @ApiResponse(responseCode = UNAUTHORIZED_CODE, description = UNAUTHORIZED, content = @Content())
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Operation(summary = "Получить задачу по идентификатору")
    @Parameter(name = "id", in = ParameterIn.PATH, description = "Идентификатор задачи", required = true,
            content = @Content(schema = @Schema(implementation = UUID.class)))
    @ApiResponse(responseCode = SUCCESS, description = "Получить задачу", useReturnTypeSchema = true)
    @ApiResponse(responseCode = UNAUTHORIZED_CODE, description = UNAUTHORIZED, content = @Content())
    @ApiResponse(responseCode = NOT_FOUND_CODE, description = NOT_FOUND_TASK, content = @Content())
    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable final UUID id) {
        return taskService.getTaskById(id);
    }

    @Operation(summary = "Создать задачу")
    @ApiResponse(responseCode = SUCCESS, description = "Задача", useReturnTypeSchema = true)
    @ApiResponse(responseCode = UNAUTHORIZED_CODE, description = UNAUTHORIZED, content = @Content())
    @PostMapping
    public UUID create(@RequestBody final TaskDto taskDto) {
        taskDto.setId(null);
        return taskService.saveOrUpdate(taskDto);
    }

    @Operation(summary = "Обновить задачу по идентификатору")
    @Parameter(name = "id", in = ParameterIn.PATH, description = "Идентификатор задачи", required = true,
            content = @Content(schema = @Schema(implementation = UUID.class)))
    @ApiResponse(responseCode = SUCCESS, description = "Обновить задачу", useReturnTypeSchema = true)
    @ApiResponse(responseCode = UNAUTHORIZED_CODE, description = UNAUTHORIZED, content = @Content())
    @ApiResponse(responseCode = FORBIDDEN_CODE, description = FORBIDDEN, content = @Content())
    @ApiResponse(responseCode = NOT_FOUND_CODE, description = NOT_FOUND_TASK, content = @Content())
    @PutMapping("/{id}")
    public UUID update(@PathVariable final UUID id, @RequestBody final TaskDto taskDto) {
        taskDto.setId(id);
        return taskService.saveOrUpdate(taskDto);
    }

    @Operation(summary = "Удалить задачу по идентификатору")
    @Parameter(name = "id", in = ParameterIn.PATH, description = "Идентификатор задачи", required = true,
            content = @Content(schema = @Schema(implementation = UUID.class)))
    @ApiResponse(responseCode = SUCCESS, description = "Удалить задачу", useReturnTypeSchema = true)
    @ApiResponse(responseCode = UNAUTHORIZED_CODE, description = UNAUTHORIZED, content = @Content())
    @ApiResponse(responseCode = FORBIDDEN_CODE, description = FORBIDDEN, content = @Content())
    @ApiResponse(responseCode = NOT_FOUND_CODE, description = NOT_FOUND_TASK, content = @Content())
    @DeleteMapping("{id}")
    public void deleteTaskById(@PathVariable final UUID id) {
        taskService.deleteTaskById(id);
    }

}

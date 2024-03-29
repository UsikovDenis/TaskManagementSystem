package ru.usikov.taskmanagementsystem.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Task Management System Api",
                description = "API для управления", version = "1.0.0"
        )
)
public class OpenApiConfig {
}

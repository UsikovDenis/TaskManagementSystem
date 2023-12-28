package ru.usikov.taskmanagementsystem.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import ru.usikov.taskmanagementsystem.IntegrationTest;
import ru.usikov.taskmanagementsystem.dto.TaskDto;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.usikov.taskmanagementsystem.TestUtils.getDefaultHeaders;

@IntegrationTest
class TaskControllerTest {

    private static final List<UUID> taskIds = List.of(
            UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
            UUID.fromString("7c9e6679-7425-40de-944b-e07fc1f90ae7"),
            UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Sql("/sql/task-controller-test-data.sql")
    void getAllTaskTest() throws Exception {
        final String getAllTaskJson = mockMvc.perform(get("/tasks")
                        .headers(getDefaultHeaders())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        final List<TaskDto> tasks = objectMapper.readValue(getAllTaskJson, new TypeReference<>() {});
        assertFalse(tasks.isEmpty());
        tasks.forEach(taskDto ->
                assertTrue(taskIds.contains(taskDto.getId())));
    }

}

package com.example.day21.controller;

import com.example.day21.model.Task;
import com.example.day21.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/tasks")
@Tag(name = "Tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @Operation(
            summary = "List tasks",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "basicAuth")
    )
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find one task",
            description = "Returns a clear 404 error if the task does not exist.",
            security = @SecurityRequirement(name = "basicAuth"),
            responses = @ApiResponse(responseCode = "404", description = "Task was not found")
    )
    public Task findById(@PathVariable long id) {
        return taskService.findById(id);
    }
}

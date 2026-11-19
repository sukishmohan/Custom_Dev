
package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE TASK
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest request) {

        TaskResponse response = taskService.createTask(request);

        return ResponseEntity
                .created(URI.create("/api/tasks/" + response.id()))
                .body(response);
    }

    // GET ALL TASKS WITH PAGINATION
    @GetMapping
    public Page<TaskResponse> getAllTasks(Pageable pageable) {

        return taskService.getAllTasks(pageable);
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id) {

        return taskService.getTaskById(id);
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request) {

        return taskService.updateTask(id, request);
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
    }

    // SEARCH TASKS
    @GetMapping("/search")
    public List<TaskResponse> searchTasks(
            @RequestParam String keyword) {

        return taskService.searchTasks(keyword);
    }
}

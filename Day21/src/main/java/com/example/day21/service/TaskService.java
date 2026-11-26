package com.example.day21.service;

import com.example.day21.exception.TaskNotFoundException;
import com.example.day21.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = List.of(
            new Task(1, "Read the project README", false),
            new Task(2, "Review the API documentation", true)
    );

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(long id) {
        return tasks.stream()
                .filter(task -> task.id() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}

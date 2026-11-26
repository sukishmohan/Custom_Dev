package com.example.day21.service;

import com.example.day21.exception.TaskNotFoundException;
import com.example.day21.model.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskServiceTest {

    private final TaskService taskService = new TaskService();

    @Test
    void returnsTaskWithMatchingId() {
        Task task = taskService.findById(1);

        assertEquals("Read the project README", task.title());
    }

    @Test
    void throwsHelpfulErrorWhenTaskIsMissing() {
        TaskNotFoundException error = assertThrows(
                TaskNotFoundException.class,
                () -> taskService.findById(99)
        );

        assertEquals("Task 99 was not found.", error.getMessage());
    }
}

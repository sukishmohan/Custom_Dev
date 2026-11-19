
package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task(
                1L,
                "Learn Java",
                "Practice unit testing",
                false
        );
    }

    @Test
    void createTaskTest() {

        TaskRequest request = new TaskRequest(
                "Learn Java",
                "Practice unit testing",
                false
        );

        when(taskRepository.save(any(Task.class)))
                .thenReturn(task);

        TaskResponse response = taskService.createTask(request);

        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals("Learn Java", response.title());

        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void getTaskByIdTest() {

        when(taskRepository.findById(1L))
                .thenReturn(Optional.of(task));

        TaskResponse response = taskService.getTaskById(1L);

        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals("Learn Java", response.title());

        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void getTaskByIdNotFoundTest() {

        when(taskRepository.findById(100L))
                .thenReturn(Optional.empty());

        assertThrows(
                TaskNotFoundException.class,
                () -> taskService.getTaskById(100L)
        );

        verify(taskRepository, times(1)).findById(100L);
    }
}

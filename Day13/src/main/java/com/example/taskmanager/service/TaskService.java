
package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final ConcurrentHashMap<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    // CREATE
    public TaskResponse createTask(TaskRequest request) {
        Long id = idGenerator.incrementAndGet();

        Task task = new Task(
            id,
            request.title(),
            request.description(),
            request.completed()
        );

        tasks.put(id, task);
        return toResponse(task);
    }

    // READ ALL
    public List<TaskResponse> getAllTasks() {
        return tasks.values().stream()
            .map(this::toResponse)
            .sorted((a, b) -> Long.compare(a.id(), b.id()))
            .toList();
    }

    // READ BY ID
    public TaskResponse getTaskById(Long id) {
        return toResponse(findTask(id));
    }

    // UPDATE
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task updated = tasks.computeIfPresent(id, (key, existing) ->
            new Task(
                key,
                request.title(),
                request.description(),
                request.completed()
            )
        );

        if (updated == null) {
            throw new TaskNotFoundException(id);
        }

        return toResponse(updated);
    }

    // DELETE
    public void deleteTask(Long id) {
        if (tasks.remove(id) == null) {
            throw new TaskNotFoundException(id);
        }
    }

    private Task findTask(Long id) {
        Task task = tasks.get(id);

        if (task == null) {
            throw new TaskNotFoundException(id);
        }

        return task;
    }

    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.isCompleted()
        );
    }
}

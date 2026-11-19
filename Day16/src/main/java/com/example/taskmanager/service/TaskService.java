
package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private static final Logger log =
            LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(TaskRequest request) {
        log.info("Creating a new task: {}", request.title());

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.completed()
        );

        Task savedTask = taskRepository.save(task);

        log.info("Task created successfully with ID: {}", savedTask.getId());

        return toResponse(savedTask);
    }

    public Page<TaskResponse> getAllTasks(Pageable pageable) {
        log.info("Fetching all tasks");

        return taskRepository.findAll(pageable)
                .map(this::toResponse);
    }

    public TaskResponse getTaskById(Long id) {
        log.info("Fetching task with ID: {}", id);

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Task not found with ID: {}", id);
                    return new TaskNotFoundException(id);
                });

        return toResponse(task);
    }

    public TaskResponse updateTask(Long id, TaskRequest request) {
        log.info("Updating task with ID: {}", id);

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Task not found with ID: {}", id);
                    return new TaskNotFoundException(id);
                });

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setCompleted(request.completed());

        Task updatedTask = taskRepository.save(task);

        log.info("Task updated successfully with ID: {}", id);

        return toResponse(updatedTask);
    }

    public void deleteTask(Long id) {
        log.info("Deleting task with ID: {}", id);

        if (!taskRepository.existsById(id)) {
            log.warn("Task not found with ID: {}", id);
            throw new TaskNotFoundException(id);
        }

        taskRepository.deleteById(id);

        log.info("Task deleted successfully with ID: {}", id);
    }

    public List<TaskResponse> searchTasks(String keyword) {
        log.info("Searching tasks with keyword: {}", keyword);

        return taskRepository.searchByTitle(keyword)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<TaskResponse> getPendingTasks() {
        log.info("Fetching pending tasks");

        return taskRepository.findPendingTasks()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<TaskResponse> getCompletedTasks() {
        log.info("Fetching completed tasks");

        return taskRepository.findCompletedTasks()
                .stream()
                .map(this::toResponse)
                .toList();
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

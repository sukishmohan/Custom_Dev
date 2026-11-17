
package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // CREATE TASK
    public TaskResponse createTask(TaskRequest request) {

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.completed()
        );

        Task savedTask = taskRepository.save(task);

        return toResponse(savedTask);
    }

    // GET ALL TASKS WITH PAGINATION
    public Page<TaskResponse> getAllTasks(Pageable pageable) {

        return taskRepository.findAll(pageable)
                .map(this::toResponse);
    }

    // GET TASK BY ID
    public TaskResponse getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return toResponse(task);
    }

    // UPDATE TASK
    public TaskResponse updateTask(Long id, TaskRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setCompleted(request.completed());

        Task updatedTask = taskRepository.save(task);

        return toResponse(updatedTask);
    }

    // DELETE TASK
    public void deleteTask(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }

        taskRepository.deleteById(id);
    }

    // SEARCH TASKS BY TITLE
    public List<TaskResponse> searchTasks(String keyword) {

        return taskRepository
                .findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // CONVERT ENTITY TO RESPONSE DTO
    private TaskResponse toResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }
}

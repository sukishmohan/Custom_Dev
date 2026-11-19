
package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.ANY
)
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void saveTaskTest() {

        Task task = new Task(
                null,
                "Learn Spring Boot",
                "Practice repository testing",
                false
        );

        Task savedTask = taskRepository.save(task);

        assertNotNull(savedTask.getId());
        assertEquals("Learn Spring Boot", savedTask.getTitle());
    }

    @Test
    void searchByTitleTest() {

        Task task = new Task(
                null,
                "Learn Java",
                "Practice Java programming",
                false
        );

        taskRepository.save(task);

        List<Task> result =
                taskRepository.searchByTitle("Java");

        assertEquals(1, result.size());
        assertEquals("Learn Java", result.get(0).getTitle());
    }

    @Test
    void findPendingTasksTest() {

        Task pendingTask = new Task(
                null,
                "Pending Task",
                "Not completed",
                false
        );

        Task completedTask = new Task(
                null,
                "Completed Task",
                "Already completed",
                true
        );

        taskRepository.save(pendingTask);
        taskRepository.save(completedTask);

        List<Task> result =
                taskRepository.findPendingTasks();

        assertEquals(1, result.size());
        assertEquals("Pending Task", result.get(0).getTitle());
    }

    @Test
    void findCompletedTasksTest() {

        Task task = new Task(
                null,
                "Completed Task",
                "Task finished",
                true
        );

        taskRepository.save(task);

        List<Task> result =
                taskRepository.findCompletedTasks();

        assertEquals(1, result.size());
        assertEquals("Completed Task", result.get(0).getTitle());
    }
}

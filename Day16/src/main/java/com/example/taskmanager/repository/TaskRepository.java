
package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Search tasks by title
    @Query("SELECT t FROM Task t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Task> searchByTitle(@Param("keyword") String keyword);

    // Find all pending tasks
    @Query("SELECT t FROM Task t WHERE t.completed = false")
    List<Task> findPendingTasks();

    // Find all completed tasks
    @Query("SELECT t FROM Task t WHERE t.completed = true")
    List<Task> findCompletedTasks();
}
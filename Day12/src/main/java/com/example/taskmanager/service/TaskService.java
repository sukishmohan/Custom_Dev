package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public String getWelcomeMessage() {
        return "Welcome to Task Manager API!";
    }

}
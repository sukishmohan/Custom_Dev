package com.example.day21.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin")
public class AdminController {

    @GetMapping("/dashboard")
    @Operation(
            summary = "View the admin area",
            description = "Requires ADMIN role.",
            security = @SecurityRequirement(name = "basicAuth")
    )
    public Map<String, String> dashboard() {
        return Map.of("message", "Welcome to the ADMIN area.");
    }
}

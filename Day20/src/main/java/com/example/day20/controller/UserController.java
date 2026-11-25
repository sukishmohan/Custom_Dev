package com.example.day20.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User")
public class UserController {

    @GetMapping("/profile")
    @Operation(
            summary = "View the user area",
            description = "Requires the USER or ADMIN role.",
            security = @SecurityRequirement(name = "basicAuth")
    )
    public Map<String, String> profile() {
        return Map.of("message", "You have the USER role or higher.");
    }
}

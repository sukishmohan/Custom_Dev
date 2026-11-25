package com.example.day20.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/public")
@Tag(name = "Public")
public class PublicController {

    @GetMapping("/hello")
    @Operation(summary = "Public welcome", description = "This endpoint does not need a username or password.")
    public Map<String, String> hello() {
        return Map.of("message", "Hello! This endpoint is public.");
    }
}

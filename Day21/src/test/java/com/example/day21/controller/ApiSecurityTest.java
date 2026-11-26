package com.example.day21.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void publicEndpointDoesNotNeedLogin() throws Exception {
        mockMvc.perform(get("/api/public/hello"))
                .andExpect(status().isOk());
    }

    @Test
    void userEndpointNeedsLogin() throws Exception {
        mockMvc.perform(get("/api/user/profile"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void userCanOpenUserEndpoint() throws Exception {
        mockMvc.perform(get("/api/user/profile").with(httpBasic("student", "user123")))
                .andExpect(status().isOk());
    }

    @Test
    void userCannotOpenAdminEndpoint() throws Exception {
        mockMvc.perform(get("/api/admin/dashboard").with(httpBasic("student", "user123")))
                .andExpect(status().isForbidden());
    }

    @Test
    void adminCanOpenAdminEndpoint() throws Exception {
        mockMvc.perform(get("/api/admin/dashboard").with(httpBasic("admin", "admin123")))
                .andExpect(status().isOk());
    }

    @Test
    void missingTaskReturnsReadableNotFoundResponse() throws Exception {
        mockMvc.perform(get("/api/user/tasks/99").with(httpBasic("student", "user123")))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("Task 99 was not found."));
    }
}

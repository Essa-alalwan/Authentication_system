package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/me")
    public Map<String, Object> me(Principal principal) {
        return Map.of(
                "message", "You are authenticated ✅",
                "username", principal == null ? null : principal.getName()
        );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/panel")
    public Map<String, Object> adminPanel(Principal principal) {
        return Map.of(
                "message", "Welcome ADMIN ✅",
                "username", principal == null ? null : principal.getName()
        );
    }
}

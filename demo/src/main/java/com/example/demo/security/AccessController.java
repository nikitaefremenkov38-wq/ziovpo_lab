package com.example.demo.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/access")
public class AccessController {

    @GetMapping("/user")
    public Map<String, String> userAccess() {
        return Map.of("access", "USER");
    }

    @GetMapping("/manager")
    public Map<String, String> managerAccess() {
        return Map.of("access", "MANAGER");
    }

    @GetMapping("/admin")
    public Map<String, String> adminAccess() {
        return Map.of("access", "ADMIN");
    }
}

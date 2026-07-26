package com.devfolio.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfolio.backend.entity.Admin;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://dev-folio-y8wt.vercel.app"
})
public class AdminController {

    // Admin Login
    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {

        if ("admin".equals(admin.getUsername())
                && "admin123".equals(admin.getPassword())) {

            return "Login Successful";
        }

        return "Invalid Username or Password";
    }
}

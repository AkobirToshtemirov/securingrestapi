package com.pdp.securingrestapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {


    @GetMapping("/hi")
    public String hi() {
        return "Hello World!";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Hello World ADMIN!";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping("/manager")
    public String manager() {
        return "Hello World MANAGER! => Can enter only ADMIN and MANAGER!";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user")
    public String user() {
        return "Hello World! => Can enter user with any Role, only should be Authenticated!!";
    }
}

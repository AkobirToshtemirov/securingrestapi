package com.pdp.securingrestapi.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(tags = {
        @io.swagger.v3.oas.annotations.tags.Tag(name = "Admin", description = "Endpoints for Admin"),
        @io.swagger.v3.oas.annotations.tags.Tag(name = "User", description = "Endpoints for User")
})
@RequestMapping("/api")
public class ApiController {
    // controllers methods here...
}

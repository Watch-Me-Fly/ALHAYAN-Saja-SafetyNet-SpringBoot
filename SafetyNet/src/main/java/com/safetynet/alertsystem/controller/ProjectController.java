package com.safetynet.alertsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @RequestMapping
    public String projectController() {
        return "HTTP/1.1 200 OK";
    }
}

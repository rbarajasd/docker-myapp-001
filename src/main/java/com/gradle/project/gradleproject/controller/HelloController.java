package com.gradle.project.gradleproject.controller;

import com.gradle.project.gradleproject.constants.Constants;
import com.gradle.project.gradleproject.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    VisitsService service;

    @GetMapping("/")
    public String home() {
        return Constants.STR_HELLO_DOCKER;
    }

    @GetMapping(path = "/visits")
    public String visits() {
        return "Visit number " + service.addVisit().getVisits();
    }
}
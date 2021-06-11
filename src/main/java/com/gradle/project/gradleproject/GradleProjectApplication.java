package com.gradle.project.gradleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GradleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleProjectApplication.class, args);
	}

}

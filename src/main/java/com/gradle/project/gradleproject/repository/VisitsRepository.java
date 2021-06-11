package com.gradle.project.gradleproject.repository;

import com.gradle.project.gradleproject.model.VisitsModel;
import org.springframework.data.repository.CrudRepository;

public interface VisitsRepository extends CrudRepository<VisitsModel, String> {
}

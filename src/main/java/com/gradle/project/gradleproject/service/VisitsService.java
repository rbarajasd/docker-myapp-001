package com.gradle.project.gradleproject.service;

import com.gradle.project.gradleproject.model.VisitsModel;
import com.gradle.project.gradleproject.repository.VisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitsService {
    @Autowired
    VisitsRepository repository;

    public VisitsModel addVisit(){
        VisitsModel visits = getVisits();
        visits.addVisit();
        return repository.save(visits);
    }

    private VisitsModel getVisits(){
        Optional<VisitsModel> optional = repository.findById("visits");
        return optional.isPresent()? optional.get(): new VisitsModel();
    }
}

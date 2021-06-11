package com.gradle.project.gradleproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("VisitsModel")
public class VisitsModel implements Serializable {
    @Id
    private String key = "visits";
    private int visits;

    public int getVisits() {
        return visits;
    }

    public void addVisit() {
        visits++;
    }

    public String getKey() {
        return key;
    }
}

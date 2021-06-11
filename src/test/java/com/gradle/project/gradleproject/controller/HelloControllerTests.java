package com.gradle.project.gradleproject.controller;

import com.gradle.project.gradleproject.constants.Constants;
import com.gradle.project.gradleproject.model.VisitsModel;
import com.gradle.project.gradleproject.repository.VisitsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTests {

    @LocalServerPort
    private int port;

    @MockBean
    private VisitsRepository repository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private HelloController controller;

    @Test
    void contextLoads(){
        assertThat(controller).isNotNull();
    }

    @Test
    void homeShouldReturnDefaultMessage(){
        assertThat(this.template.getForObject("http://localhost:" + port + "/", String.class)).isEqualTo(Constants.STR_HELLO_DOCKER);
    }

    @Test
    void visitsDistinctThanZero(){
        VisitsModel visits = new VisitsModel();
        visits.addVisit();
        when(repository.findById(visits.getKey())).thenReturn(Optional.of(visits));
        when(repository.save(visits)).thenReturn(visits);
        assertThat(this.template.getForObject("http://localhost:" + port + "/visits", String.class)).isEqualTo("Visit number " + visits.getVisits());

    }
}

package com.javaacademy.job_search.unit_tests;

import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Vacancy;
import com.javaacademy.job_search.services.supportServices.ResumePlacementService;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.Resume;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("china")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ResumePlacementServiceTest {
    @Autowired
    ResumePlacementService service;

    @Test
    void UserEquals() {
        Assertions.assertEquals(new User("имя", "email"), service.createUser("имя", "email"));
    }

    @Test
    void VacansyEquals() {
        User user = new User("Dima", "emaill");
        service.createResume(user, BigDecimal.valueOf(1000), "description");
        Assertions.assertEquals(new Resume(BigDecimal.valueOf(1000), "description"), service.getResumeList().get(0));
    }
}

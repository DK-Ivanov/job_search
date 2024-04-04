package com.javaacademy.job_search;

import com.javaacademy.job_search.services.JobSearchService;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Vacancy;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.Resume;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("japan")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class RunnerJapanTests {
    @Autowired
    JobSearchService service;
    @Test
    void contextLoads() {
        Company company1 = service.createCompany("Компания");
        User user = service.createUser("Дмитрий", "dima@grambler.ru");
        Assertions.assertEquals(new Company("Компания"), company1);
        Assertions.assertEquals(new User("Дмитрий", "dima@grambler.ru"), user);

        service.createVacansy(company1, "Программист", "Нужно программировать", BigDecimal.valueOf(1000));
        Assertions.assertEquals(new Vacancy("Программист", "Нужно программировать", BigDecimal.valueOf(1000), "Jena"),service.getCompanyVacancy(company1).get(0));

        service.createResume(user, BigDecimal.valueOf(1000), "Умею программировать");
        Assertions.assertEquals(new Resume(BigDecimal.valueOf(1000), "Умею программировать"),service.getResumeList().get(0));
    }
}

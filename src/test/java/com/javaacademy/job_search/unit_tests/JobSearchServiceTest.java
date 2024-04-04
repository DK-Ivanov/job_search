package com.javaacademy.job_search.unit_tests;

import com.javaacademy.job_search.services.JobSearchService;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Vacancy;
import com.javaacademy.job_search.services.supportServices.JobServices.JobPlacementService;
import com.javaacademy.job_search.services.supportServices.ResumePlacementService;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.Resume;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@ActiveProfiles("japan")
public class JobSearchServiceTest {
    @Autowired
    JobSearchService service;

    @MockBean
    private JobPlacementService jobPlacementService;

    @MockBean
    private ResumePlacementService resumePlacementService;


    @Test
    void Test() {
        Mockito.when(jobPlacementService.createCompany(Mockito.anyString())).thenReturn(new Company("1"));
        Mockito.when(jobPlacementService.getCompanyVacancy(Mockito.any())).thenReturn(List.of(new Vacancy("1", "2", BigDecimal.valueOf(3), "Jena")));
        Mockito.when(resumePlacementService.createUser(Mockito.anyString(), Mockito.anyString())).thenReturn(new User("1", "2"));
        Mockito.when(resumePlacementService.getResumeList()).thenReturn(List.of(new Resume(BigDecimal.valueOf(1), "2")));
        Assertions.assertEquals(new Company("1"), service.createCompany("1"));
        Assertions.assertEquals(new Vacancy("1", "2", BigDecimal.valueOf(3), "Jena"), service.getCompanyVacancy(new Company("2")).get(0));
        Assertions.assertEquals(new User("1", "2"), service.createUser("3", "4"));
        Assertions.assertEquals(new Resume(BigDecimal.valueOf(1), "2"), service.getResumeList().get(0));
    }
}

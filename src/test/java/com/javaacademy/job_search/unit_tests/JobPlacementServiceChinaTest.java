package com.javaacademy.job_search.unit_tests;

import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Vacancy;
import com.javaacademy.job_search.services.supportServices.JobServices.JobPlacementServiceChina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("china")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class JobPlacementServiceChinaTest {
    @Autowired
    JobPlacementServiceChina serviceChina;

    @Test
    void currencyEquals() {
        Assertions.assertEquals("Yuan",serviceChina.getCurrency());
    }

    @Test
    void CompanyEquals() {
        Assertions.assertEquals(new Company("имя"), serviceChina.createCompany("имя"));
    }

    @Test
    void VacansyEquals() {
        Company company = new Company("company");
        serviceChina.createVacansy(company, "1", "2", BigDecimal.valueOf(3));
        Assertions.assertEquals(new Vacancy("1", "2", BigDecimal.valueOf(3), "Yuan"), serviceChina.getCompanyVacancy(company).get(0));
    }

}

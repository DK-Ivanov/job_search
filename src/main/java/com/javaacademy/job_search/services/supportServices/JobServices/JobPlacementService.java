package com.javaacademy.job_search.services.supportServices.JobServices;

import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Vacancy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;


public abstract class JobPlacementService {
    public abstract Company createCompany(String name);

    public abstract void createVacansy(Company company, String positions, String description, BigDecimal salary);

    public abstract List<Vacancy> getCompanyVacancy(Company company);
}

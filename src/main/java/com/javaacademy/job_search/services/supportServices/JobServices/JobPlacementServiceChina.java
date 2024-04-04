package com.javaacademy.job_search.services.supportServices.JobServices;

import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Vacancy;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@Profile("china")
public class JobPlacementServiceChina extends JobPlacementService{
    @Getter
    @Value("${currency}")
    private String currency;
    private LinkedHashMap<String, Company> companies = new LinkedHashMap<>();

    public Company createCompany(String name) {
        Company company = new Company(name);
        companies.put(name, company);
        return company;
    }

    @Override
    public void createVacansy(Company company, String positions, String description, BigDecimal salary) {
        company.createVacancy(positions, description, salary, this.currency);
    }

    public List<Vacancy> getCompanyVacancy(Company company) {
        return company.getVacancies();
    }
}

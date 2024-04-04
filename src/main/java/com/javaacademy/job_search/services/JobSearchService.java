package com.javaacademy.job_search.services;

import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Vacancy;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.Resume;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.User;
import com.javaacademy.job_search.services.supportServices.JobServices.JobPlacementService;
import com.javaacademy.job_search.services.supportServices.ResumePlacementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class JobSearchService {
    private JobPlacementService jobPlacementService;
    private ResumePlacementService resumePlacementService;

    public Company createCompany(String name) {
        return jobPlacementService.createCompany(name);
    }

    public void createVacansy(Company company, String positions, String description, BigDecimal salary) {
        jobPlacementService.createVacansy(company, positions, description, salary);
    }

    public List<Vacancy> getCompanyVacancy(Company company) {
        return jobPlacementService.getCompanyVacancy(company);
    }

    public User createUser(String name, String email) {
        return resumePlacementService.createUser(name, email);

    }

    public void createResume(User user, BigDecimal salary, String description) {
        resumePlacementService.createResume(user, salary, description);
    }

    public List<Resume> getResumeList() {
        return resumePlacementService.getResumeList();
    }

}

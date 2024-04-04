package com.javaacademy.job_search;

import com.javaacademy.job_search.services.JobSearchService;
import com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools.Company;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
		JobSearchService service = context.getBean(JobSearchService.class);
		Company company1 = service.createCompany("Компания");
		service.createVacansy(company1, "Программист", "Нужно программировать", BigDecimal.valueOf(1000));
		System.out.println(service.getCompanyVacancy(company1));

		User user = service.createUser("Дмитрий", "dima@grambler.ru");
		service.createResume(user, BigDecimal.valueOf(1000), "Умею программировать");
		System.out.println(service.getResumeList());

	}

}

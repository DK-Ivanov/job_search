package com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class Company {
    @NonNull private String name;
    @Getter
    private List<Vacancy> vacancies = new ArrayList<>();

    public void createVacancy(String positions, String description, BigDecimal salary, String currency) {
        vacancies.add(new Vacancy(positions, description, salary, currency));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

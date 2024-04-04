package com.javaacademy.job_search.services.supportServices.JobPlacementServiceTools;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
public class Vacancy {
    private String positions;
    private String description;
    private BigDecimal salary;
    private String currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(positions, vacancy.positions) && Objects.equals(description, vacancy.description) && Objects.equals(salary, vacancy.salary) && Objects.equals(currency, vacancy.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions, description, salary, currency);
    }
}

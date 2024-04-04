package com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
public class Resume {
    private BigDecimal salary;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(salary, resume.salary) && Objects.equals(description, resume.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, description);
    }
}

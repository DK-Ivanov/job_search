package com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class User {
    @NonNull private String name;
    @NonNull private String email;
    private Resume resume;

    public Resume createResume(BigDecimal salary, String description) {
        resume = new Resume(salary, description);
        return resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}

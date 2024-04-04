package com.javaacademy.job_search.services.supportServices;

import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.Resume;
import com.javaacademy.job_search.services.supportServices.ResumePlacementServiceTools.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResumePlacementService {
    private List<User> users = new ArrayList<>();
    private List<Resume> resumes = new ArrayList<>();

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
        return user;
    }

    public void createResume(User user, BigDecimal salary, String description) {
        resumes.add(new Resume(salary, description));
    }

    public List<Resume> getResumeList() {
        return resumes;
    }


}

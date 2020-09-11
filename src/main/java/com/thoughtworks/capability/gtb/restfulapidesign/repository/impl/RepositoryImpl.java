package com.thoughtworks.capability.gtb.restfulapidesign.repository.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryImpl implements StudentRepository {
    private final Map<String,Student> students = new HashMap<>();

    @Override
    public Student save(Student student) {
        student.setId(students.size() + 1);
        students.put(student.getName(),student);
        return student;
    }

    @Override
    public void delete(String name) {
        students.remove(name);
    }
}

package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
    Student save( Student student);

    void delete(String name);

    Student getStudent(String name);
}

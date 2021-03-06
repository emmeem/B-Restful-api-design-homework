package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    Student save( Student student);

    void delete(Student student);

    Student findByName(String name);

    Student update(Integer id, Student student);

    Student findById(Integer id);

    List<Student> getStudents();

    List<Student> getStudentsByGender(String gender);
}

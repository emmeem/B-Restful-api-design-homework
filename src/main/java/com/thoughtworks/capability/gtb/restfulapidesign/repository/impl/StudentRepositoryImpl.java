package com.thoughtworks.capability.gtb.restfulapidesign.repository.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final Map<Integer,Student> students = new HashMap<>();

    @Override
    public Student save(Student student) {
        student.setId(students.size() + 1);
        students.put(student.getId(),student);
        return student;
    }

    @Override
    public void delete(Student student) {
                students.keySet().removeIf(key -> key == student.getId());
    }


    @Override
    public Student findByName(String name) {
        for (Student student : students.values()) {
           if(student.getName().equals(name)) {
               return student;
           }
        }
        return null;
    }

    @Override
    public Student update(Integer id, Student student) {
        students.put(id, student);
        return findById(id);
    }

    @Override
    public Student findById(Integer id) {
        return students.get(id);
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>(students.values());
        return studentList;
    }

    @Override
    public List<Student> getStudentsByGender(String gender) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students.values()) {
            if(student.getGender().equals(gender)) {
                studentList.add(student);
            }
        }
        return  studentList;
    }
}

package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String name) {
        studentRepository.delete(name);
    }

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student updateStudentInfo(Integer id, Student student) {
        if(studentRepository.findById(id) != null) {
            return studentRepository.update(id, student);
        }
        return null;
    }
}

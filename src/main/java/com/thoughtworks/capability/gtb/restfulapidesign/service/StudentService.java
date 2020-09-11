package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentRequest;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public StudentRequest addStudent(StudentRequest studentRequest) {
        Student newStudent = Student.builder()
                .name(studentRequest.getStudentName())
                .gender(studentRequest.getStudentGender())
                .note(studentRequest.getStudentNote())
                .build();
        Student addStudent = studentRepository.save(newStudent);
        return  StudentRequest.builder()
                .studentName(addStudent.getName())
                .studentGender(addStudent.getGender())
                .studentNote(addStudent.getNote())
                .build();
    }

    public void deleteStudent(String name) {
        studentRepository.delete(name);
    }

    public StudentRequest getStudent(String name) {
        Student student = studentRepository.getStudent(name);
        return  StudentRequest.builder()
                .studentName(student.getName())
                .studentGender(student.getGender())
                .studentNote(student.getNote())
                .build();
    }

}

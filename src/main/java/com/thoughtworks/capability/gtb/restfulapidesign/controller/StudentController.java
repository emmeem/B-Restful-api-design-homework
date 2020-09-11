package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentRequest;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(studentRequest));
    }


    @DeleteMapping("/students/{studentName}")
    public ResponseEntity deleteStudent(@PathVariable String studentName) {
        studentService.deleteStudent(studentName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

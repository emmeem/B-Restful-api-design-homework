package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.addStudent(student));
    }

    @DeleteMapping("/students/{name}")
    public ResponseEntity deleteStudent(@PathVariable String name) {
        studentService.deleteStudent(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.status(HttpStatus.OK)
               .body(studentService.getStudents());
    }

    @GetMapping("/students/genders/{gender}")
    public ResponseEntity<List<Student>> getStudentsByGender(@PathVariable String gender) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getStudentsByGender(gender));
    }

    @GetMapping("/students/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getStudentByName(name));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity updateStudentInfo(@PathVariable Integer id, @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.updateStudentInfo(id ,student));
    }

}

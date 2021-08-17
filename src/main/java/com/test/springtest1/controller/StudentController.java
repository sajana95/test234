package com.test.springtest1.controller;

import com.test.springtest1.enitiy.Student;
import com.test.springtest1.exception.notFoundException;
import com.test.springtest1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) throws notFoundException {
        return studentService.saveStudent(student);
    }

    @GetMapping("/student")
    public List<Student> fetchStudentList() {
        return studentService.fetchStudentList();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId) throws notFoundException {
        return studentService.getStudentByid(studentId);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId, @RequestBody Student student) throws notFoundException {
        return studentService.updateStudent(studentId, student);
    }

}

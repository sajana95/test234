package com.test.springtest1.service;

import com.test.springtest1.enitiy.Course;
import com.test.springtest1.enitiy.Student;
import com.test.springtest1.exception.notFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentService {

    Student saveStudent(Student student) throws notFoundException;

    List<Student> fetchStudentList();

    Student getStudentByid(Long studentId) throws notFoundException;

    Student updateStudent(Long studentId, Student student) throws notFoundException;
}

package com.test.springtest1.service;

import com.test.springtest1.enitiy.Student;
import com.test.springtest1.exception.notFoundException;
import com.test.springtest1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) throws notFoundException {

        if (student.getFirstName().isEmpty()) {
            throw new notFoundException("first name not found !");
        } else if (student.getLastName().isEmpty()) {
            throw new notFoundException(" last name not found !");
        } else if (getAge(student) > 10) {
            throw new notFoundException("invalid age ");
        } else if (!student.getPhoneNumber().matches("(0/94)?[7-9][0-9]{9}")) {
            throw new notFoundException("invalid phone number");
        } else if (!student.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new notFoundException("invalid email");
        } else if (!student.getGender().equalsIgnoreCase("male") || !student.getGender().equalsIgnoreCase("female")) {
            throw new notFoundException("invalid gender");
        } else if (student.getAddress().isEmpty()) {
            throw new notFoundException("address not found");
        }
        return studentRepository.save(student);

    }

    public int getAge(Student student) {
        Date currentUtilDate = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(student.getBirthDay()));
        int d2 = Integer.parseInt(formatter.format(currentUtilDate));
        return (d2 - d1) / 10000;
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByid(Long studentId) throws notFoundException {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new notFoundException("student not found! invalid student ID");
        }
        return student.get();
    }

    @Override
    public Student updateStudent(Long studentId, Student student) throws notFoundException {
        Student temp = getStudentByid(studentId);

        if (temp.getStudentId() == 0) {
            throw new notFoundException("invalid student id");
        }
        if (!student.getFirstName().isEmpty()) {
            temp.setFirstName(student.getFirstName());
        }
        if (!student.getLastName().isEmpty()) {
            temp.setLastName(student.getLastName());
        }
        if (getAge(student) > 10) {
            temp.setBirthDay(student.getBirthDay());
        }
        if (!student.getPhoneNumber().matches("(0/94)?[7-9][0-9]{9}")) {
            temp.setPhoneNumber(student.getPhoneNumber());
        }
        if (!student.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            temp.setEmail(student.getEmail());
        }
        if (!student.getGender().equalsIgnoreCase("male") || !student.getGender().equalsIgnoreCase("female")) {
            temp.setGender(student.getGender());
        }
        if (student.getAddress().isEmpty()) {
            temp.setAddress(student.getAddress());
        }
        return studentRepository.save(temp);
    }
}


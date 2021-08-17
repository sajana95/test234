package com.test.springtest1.controller;

import com.test.springtest1.enitiy.Course;
import com.test.springtest1.exception.notFoundException;
import com.test.springtest1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course) throws notFoundException {
        return courseService.saveCourse(course);
    }

    @GetMapping("/course")
    public List<Course> fetchCourseList() {
        return courseService.fetchCourseList();
    }

    @GetMapping("/course/{id}")
    public Course getStudentById(@PathVariable("id") Long courseId) throws notFoundException {
        return courseService.getCourseByid(courseId);
    }

    @PutMapping("/course/{id}")
    public Course updateCourse(@PathVariable("id") Long courseId, @RequestBody Course course) throws notFoundException {
        return courseService.updateCourse(courseId, course);
    }


}

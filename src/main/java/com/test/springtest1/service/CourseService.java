package com.test.springtest1.service;

import com.test.springtest1.enitiy.Course;
import com.test.springtest1.exception.notFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseService {
    Course saveCourse(Course course) throws notFoundException;

    List<Course> fetchCourseList();

    Course getCourseByid(Long courseId) throws notFoundException;

    Course updateCourse(Long courseId, Course course) throws notFoundException;

}

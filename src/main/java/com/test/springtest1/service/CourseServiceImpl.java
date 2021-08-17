package com.test.springtest1.service;

import com.test.springtest1.enitiy.Course;
import com.test.springtest1.exception.notFoundException;
import com.test.springtest1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) throws notFoundException {

        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (course.getCourseName().isEmpty()) {
            throw new notFoundException("course name not found !");
        } else if (course.getStartDate().after(date)) {
            throw new notFoundException(" date not found !");
        } else if (course.getStatus().equals("Inactive") || course.getStatus().equals("Active")
                && course.getStatus().isEmpty()) {
            throw new notFoundException("status not found");
        }
        return courseRepository.save(course);
    }

    @Override
    public List<Course> fetchCourseList() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByid(Long courseId) throws notFoundException {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isEmpty()) {
            throw new notFoundException("course not found! invalid course ID");
        }
        return course.get();
    }

    @Override
    public Course updateCourse(Long courseId, Course course) throws notFoundException {
        Course temp = getCourseByid(courseId);
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (temp.getCourseId() == 0) {
            throw new notFoundException("invalid course id");
        }
        if (!course.getCourseName().isEmpty()) {
            temp.setCourseName(course.getCourseName());
        }
        if (!course.getStartDate().after(date)) {
            temp.setStartDate(course.getStartDate());
        }
        if (!course.getStatus().isEmpty()) {
            temp.setStatus(course.getStatus());
        }
        return courseRepository.save(temp);
    }

}

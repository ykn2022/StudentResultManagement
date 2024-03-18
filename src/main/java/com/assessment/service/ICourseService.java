package com.assessment.service;

import java.util.List;

import com.assessment.dto.CourseDTO;
import com.assessment.entity.Course;
import com.assessment.exception.DuplicateEntityException;


public interface ICourseService {

    List<CourseDTO> findAll();
    CourseDTO addCourse(Course course) throws DuplicateEntityException;
    void deleteCourse(int courseId);
}

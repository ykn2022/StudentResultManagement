package com.assessment.repository;

import java.util.List;

import com.assessment.entity.Course;

public interface CourseRepositoryCustom {

    List<Course> findByCourseName(String courseName);

}

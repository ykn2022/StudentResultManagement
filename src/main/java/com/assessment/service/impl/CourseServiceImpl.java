package com.assessment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.converter.CourseConverter;
import com.assessment.dto.CourseDTO;
import com.assessment.entity.Course;
import com.assessment.exception.DuplicateEntityException;
import com.assessment.repository.CourseRepository;
import com.assessment.repository.ResultRepository;
import com.assessment.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
    
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ResultRepository resultRepository;

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(CourseConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO addCourse(Course course) throws DuplicateEntityException {
        List<Course> duplicateCourses = courseRepository.findByCourseName(course.getCourseName());
        if (duplicateCourses == null || duplicateCourses.isEmpty()){
            Course newCourse = courseRepository.save(course);
            return CourseConverter.entityToDto(newCourse);
        } else {
            throw new DuplicateEntityException(Course.class.getSimpleName(), "name", course.getCourseName(), null);
        }
    }

    @Override
    @Transactional
    public void deleteCourse(int courseId) {
        resultRepository.deleteByCourseCourseId(courseId);
        courseRepository.deleteById(courseId);
    }
}

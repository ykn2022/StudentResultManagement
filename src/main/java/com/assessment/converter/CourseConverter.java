package com.assessment.converter;

import com.assessment.dto.CourseDTO;
import com.assessment.entity.Course;

public class CourseConverter {

    public static Course dtoToEntity(CourseDTO courseDto) {
        return new Course(courseDto.getId(), courseDto.getCourseName());
    }

    public static CourseDTO entityToDto(Course course) {
        return new CourseDTO(course.getCourseId(), course.getCourseName());
    }    
    
}

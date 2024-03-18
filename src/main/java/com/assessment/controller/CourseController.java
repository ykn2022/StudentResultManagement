package com.assessment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.dto.CourseDTO;
import com.assessment.entity.Course;
import com.assessment.exception.DuplicateEntityException;
import com.assessment.service.impl.CourseServiceImpl;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private final CourseServiceImpl courseServiceImpl;

    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courses = courseServiceImpl.findAll();
        return ResponseEntity.ok().body(courses);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> addCourse(@Valid @RequestBody Course course) throws DuplicateEntityException {
        CourseDTO newCourse = courseServiceImpl.addCourse(course);
        return ResponseEntity.ok().body(newCourse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        courseServiceImpl.deleteCourse(id);
        return ResponseEntity.ok().build();
    }
}

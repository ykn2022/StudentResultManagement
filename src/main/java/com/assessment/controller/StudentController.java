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

import com.assessment.dto.StudentDTO;
import com.assessment.entity.Student;
import com.assessment.exception.DuplicateEntityException;
import com.assessment.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody Student student) throws DuplicateEntityException {
        StudentDTO newStudent = studentService.addStudent(student);
        return ResponseEntity.ok().body(newStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}

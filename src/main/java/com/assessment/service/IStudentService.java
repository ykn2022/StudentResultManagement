package com.assessment.service;

import java.util.List;

import com.assessment.dto.StudentDTO;
import com.assessment.entity.Student;
import com.assessment.exception.DuplicateEntityException;

public interface IStudentService {

    List<StudentDTO> findAll();
    StudentDTO addStudent(Student student) throws DuplicateEntityException;
    void deleteStudent(int studentId);

}

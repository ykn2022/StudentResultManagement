package com.assessment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.converter.StudentConverter;
import com.assessment.dto.StudentDTO;
import com.assessment.entity.Student;
import com.assessment.exception.DuplicateEntityException;
import com.assessment.repository.ResultRepository;
import com.assessment.repository.StudentRepository;
import com.assessment.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ResultRepository resultRepository;

    public List<StudentDTO> findAll(){
        return studentRepository.findAll()
                .stream()
                .map(StudentConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public StudentDTO addStudent(Student student) throws DuplicateEntityException {
        List<Student> existingStudentsWithEmail = studentRepository.findByEmailAddress(student.getEmailAddress());
        if (existingStudentsWithEmail == null || existingStudentsWithEmail.isEmpty()){
            Student newStudent = studentRepository.save(student);
            return StudentConverter.entityToDto(newStudent);
        } else {
            throw new DuplicateEntityException(Student.class.getSimpleName(), "emailAddress", student.getEmailAddress(), null);
        }
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        resultRepository.deleteByStudentStudentId(studentId);
        studentRepository.deleteById(studentId);
    }
}

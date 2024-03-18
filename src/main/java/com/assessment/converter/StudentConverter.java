package com.assessment.converter;

import com.assessment.dto.StudentDTO;
import com.assessment.entity.Student;

public class StudentConverter {

    public static Student dtoToEntity(StudentDTO studentDto) {
        return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getFamilyName(), studentDto.getBirthDate(), studentDto.getEmailAddress());
    }

    public static StudentDTO entityToDto(Student student) {
        return new StudentDTO(student.getStudentId(), student.getFirstName(), student.getFamilyName(), student.getBirthDate(), student.getEmailAddress());
    }
}

package com.assessment.repository;

import java.util.List;

import com.assessment.entity.Student;

public interface StudentRepositoryCustom {

    List<Student> findByEmailAddress(String emailAddress);

}

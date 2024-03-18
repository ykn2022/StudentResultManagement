package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.entity.Student;

@Repository
public interface StudentRepository extends StudentRepositoryCustom, JpaRepository<Student, Integer> {

}



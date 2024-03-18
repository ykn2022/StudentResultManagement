package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.entity.Course;

@Repository
public interface CourseRepository extends CourseRepositoryCustom, JpaRepository<Course, Integer> {

}

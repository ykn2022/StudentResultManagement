package com.assessment.repository;

import java.util.List;

import com.assessment.entity.Result;

public interface ResultRepositoryCustom {

    List<Result> findByCourseCourseIdAndStudentStudentId(int courseId, int studentId);
    void deleteByCourseCourseId(int courseId);
    void deleteByStudentStudentId(int studentId);
}

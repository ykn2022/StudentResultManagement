package com.assessment.dto;

import com.assessment.entity.Course;
import com.assessment.entity.Student;

public class ResultDTO {

    private Course course;
    private Student student;
    private String score;

    public ResultDTO(Course course, Student student, String score) {
        this.course = course;
        this.student = student;
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}

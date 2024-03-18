package com.assessment.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private int studentId;

    private String firstName;

    private String familyName;

    private Date birthDate;

    private String emailAddress;

    public Student() {
    }

    public Student(int studentId, String firstName, String familyName, Date birthDate, String emailAddress) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        if (studentId == student.studentId)
            return true;

        return firstName.equals(student.firstName) &&
                familyName.equals(student.familyName) &&
                birthDate.equals(student.birthDate) &&
                emailAddress.equals(student.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, familyName, birthDate, emailAddress);
    }
}

package com.assessment.dto;

import java.sql.Date;

public class StudentDTO {

    private int id;
    private String firstName;
    private String familyName;
    private Date birthDate;
    private String emailAddress;

    public StudentDTO(int studentId, String firstName, String familyName, Date birthDate, String emailAddress) {
        this.id = studentId;
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

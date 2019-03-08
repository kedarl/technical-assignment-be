package com.project.addressbook.model;

import com.project.addressbook.enums.Gender;

import java.util.Date;

public class RecordEntry {

    private Gender gender;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;

    public RecordEntry (String firstName, String lastName, Gender gender, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
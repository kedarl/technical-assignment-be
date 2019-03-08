package com.project.addressbook.model;

import com.project.addressbook.enums.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RecordEntryBuilder {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String dateOfBirth;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    public RecordEntryBuilder() {
    }

    public RecordEntryBuilder(String name, Gender defaultGender, String dateOfBirth) {
        setNames(name);
        this.gender = defaultGender;
        this.dateOfBirth = dateOfBirth;
    }

    public RecordEntryBuilder withName(String name) {
        setNames(name);
        return this;
    }

    public RecordEntryBuilder withGender(Gender gender) {
        this.gender = gender;

        return this;
    }

    public RecordEntryBuilder withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;

        return this;
    }

    public RecordEntry build() throws ParseException {
        return new RecordEntry(firstName, lastName, gender, sdf.parse(dateOfBirth));
    }

    private void setNames(String name) {
        String[] names = name.split(" ");
        this.firstName = names[0];
        this.lastName = names[1];
    }
}

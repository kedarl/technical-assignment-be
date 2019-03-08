package com.project.addressbook.enums;

public enum Gender {
    FEMALE, MALE;

    public static Gender findValue(String value) {
        Gender genderFound = null;

        for (Gender gender : Gender.values()) {
            if (gender.name().equalsIgnoreCase(value)) {
                genderFound = gender;
            }
        }

        return genderFound;
    }
}
package com.project.addressbook.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenderTest {

    @Test
    public void findValueReturnsGenderTypeForGivenValue() throws Exception {
        // expect
        assertEquals(Gender.MALE, Gender.findValue("Male"));
        assertEquals(Gender.FEMALE, Gender.findValue("Female"));
    }

}
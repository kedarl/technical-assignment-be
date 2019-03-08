package com.project.addressbook.model;

import com.project.addressbook.enums.Gender;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class RecordEntryBuilderTest {

    private RecordEntryBuilder entryBuilder;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");

    @Before
    public void setup() {
        entryBuilder = new RecordEntryBuilder("Jane Austin", Gender.FEMALE, "01/01/85");
    }

    @Test
    public void testBuildEntryDefault() throws Exception {
        // when
        RecordEntry recordEntry = entryBuilder.build();

        // then
        assertEquals(Gender.FEMALE, recordEntry.getGender());
        assertEquals("01/01/85", simpleDateFormat.format(recordEntry.getDateOfBirth()));
        assertEquals("Jane", recordEntry.getFirstName());
        assertEquals("Austin", recordEntry.getLastName());
    }

    @Test
    public void testBuildEntryWithName() throws Exception {
        // when
        RecordEntry entry = entryBuilder.withName("Jane Austin").build();

        // then
        assertEquals(entry.getFirstName(), "Jane");
        assertEquals(entry.getLastName(), "Austin");
    }

    @Test
    public void testBuildEntryWithGender() throws Exception {
        // when
        RecordEntry entry = entryBuilder.withGender(Gender.FEMALE).build();

        // then
        assertEquals(entry.getGender(), Gender.FEMALE);
    }

    @Test
    public void testBuildEntryWithDateOfBirth() throws Exception {
        // when
        RecordEntry entry = entryBuilder.withDateOfBirth("01/01/85").build();

        // then
        assertEquals("01/01/85", simpleDateFormat.format(entry.getDateOfBirth()));
    }

    @Test(expected = ParseException.class)
    public void testParseExceptionForInvalidDate() throws Exception{
        // expect
        entryBuilder.withDateOfBirth("02/03/aaaa").build();
    }

}

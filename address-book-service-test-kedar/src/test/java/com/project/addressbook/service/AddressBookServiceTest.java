package com.project.addressbook.service;

import com.project.addressbook.criteria.Criteria;
import com.project.addressbook.enums.Gender;
import com.project.addressbook.model.RecordEntry;
import com.project.addressbook.model.RecordEntryBuilder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookServiceTest {

    private AddressBookService addressBookService;
    private RecordEntryBuilder entryBuilder;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
    
    @Before
    public void setup() throws Exception {
        addressBookService = new AddressBookService();
        entryBuilder = new RecordEntryBuilder("James Holmes", Gender.FEMALE, "01/01/85");
    }

    @Test
    public void testAddRecordEntryWithGender() throws Exception {
        // expect
        assertEquals(0, addressBookService.size());

        // when
        addressBookService.addEntry(entryBuilder.withGender(Gender.FEMALE).build());

        // then
        assertEquals(1, addressBookService.size());

        // when
        addressBookService.addEntry(entryBuilder.withGender(Gender.MALE).build());

        // then
        assertEquals(2, addressBookService.size());
    }

    @Test
    public void findByTestForGivenCriteria() throws Exception {
        // given
        Criteria criteriaMock = mock(Criteria.class);
        List<RecordEntry> entriesExpected = new ArrayList<RecordEntry>();
        when(criteriaMock.query(Matchers.anyListOf(RecordEntry.class))).thenReturn(entriesExpected);

        // when
        List<RecordEntry> entries = addressBookService.findBy(criteriaMock);

        // then
        assertEquals(entriesExpected, entries);
    }
}
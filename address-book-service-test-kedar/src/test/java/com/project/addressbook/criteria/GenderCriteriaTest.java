package com.project.addressbook.criteria;

import com.project.addressbook.enums.Gender;
import com.project.addressbook.loader.AddressBookLoader;
import com.project.addressbook.loader.FileAddressBookLoader;
import com.project.addressbook.model.RecordEntry;
import com.project.addressbook.service.AddressBookService;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenderCriteriaTest {

    @Test
    public void testGenderCriteriaFromAddressBookEntries() throws Exception {
        // given
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        final List<RecordEntry> entries = new ArrayList<RecordEntry>();

        AddressBookLoader addressBookLoader = new FileAddressBookLoader("AddressBook");
        AddressBookService addressBookService = new AddressBookService() {
            public void addEntry(RecordEntry entry) {
                entries.add(entry);
            }
        };

        // when
        addressBookLoader.load(addressBookService);

        Criteria criteria = new GenderCriteria(Gender.MALE);
        List<RecordEntry> entriesForMale = criteria.query(entries);

        assertEquals(entriesForMale.size(), 3);
    }

}

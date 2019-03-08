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

public class OldestPersonCriteriaTest {

    @Test
    public void testOldestPersonCriteriaFromAddressBookEntries() throws Exception {
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

        Criteria criteria = new OldestPersonCriteria();
        List<RecordEntry> entriesForOldestPerson = criteria.query(entries);

        assertEquals(entriesForOldestPerson.get(0).getGender(), Gender.MALE);
    }

}

package com.project.addressbook.loader;

import com.project.addressbook.enums.Gender;
import com.project.addressbook.model.RecordEntry;
import com.project.addressbook.service.AddressBookService;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileAddressBookLoaderTest {

    @Test
    public void testFileAddressBookLoader() throws Exception {
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

        // then
        assertEquals(5, entries.size());

        // and
        assertEquals("Gemma", entries.get(2).getFirstName());
        assertEquals("Sarah", entries.get(3).getFirstName());
        assertEquals("Wes", entries.get(4).getFirstName());
    }
}
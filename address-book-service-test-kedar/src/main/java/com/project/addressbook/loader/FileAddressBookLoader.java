package com.project.addressbook.loader;

import com.project.addressbook.enums.Gender;
import com.project.addressbook.model.RecordEntry;
import com.project.addressbook.model.RecordEntryBuilder;
import com.project.addressbook.service.AddressBookService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileAddressBookLoader implements AddressBookLoader {

    private String filename;

    public FileAddressBookLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public void load(AddressBookService addressBookService) throws Exception {
        InputStream inputStream = Thread.currentThread().getClass().getResourceAsStream("/" + filename);
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(reader);

        String strLine;
        RecordEntryBuilder recordEntryBuilder = new RecordEntryBuilder();
        while ((strLine = br.readLine()) != null)   {
            String[] parts = strLine.split(", ");

            RecordEntry recordEntry = recordEntryBuilder.withName(parts[0])
                    .withGender(Gender.findValue(parts[1]))
                    .withDateOfBirth(parts[2])
                    .build();

            addressBookService.addEntry(recordEntry);
        }
        br.close();
    }

}
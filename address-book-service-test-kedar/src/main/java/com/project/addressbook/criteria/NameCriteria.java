package com.project.addressbook.criteria;

import com.project.addressbook.model.RecordEntry;

import java.util.ArrayList;
import java.util.List;

public class NameCriteria implements Criteria {

    private String firstName;
    private String lastName;

    public NameCriteria(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public List<RecordEntry> query(List<RecordEntry> recordEntries) {
        List<RecordEntry> entriesForName = new ArrayList<RecordEntry>();

        RecordEntry entryByName = null;
        for (RecordEntry recordEntry : recordEntries) {
            if (recordEntry.getFirstName().equalsIgnoreCase(firstName) && recordEntry.getLastName().equalsIgnoreCase(lastName)) {
                entryByName = recordEntry;
            }
        }

        if (entryByName != null) {
            entriesForName.add(entryByName);
        }

        return entriesForName;
    }
}
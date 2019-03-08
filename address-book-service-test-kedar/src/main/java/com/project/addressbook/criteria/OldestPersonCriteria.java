package com.project.addressbook.criteria;

import com.project.addressbook.model.RecordEntry;

import java.util.ArrayList;
import java.util.List;

public class OldestPersonCriteria implements Criteria {

    @Override
    public List<RecordEntry> query(List<RecordEntry> recordEntries) {
        List<RecordEntry> entriesForOldestPerson = new ArrayList<RecordEntry>();

        if (!recordEntries.isEmpty()) {
            RecordEntry entryForOldestPerson = recordEntries.get(0);
            for (int i = 1; i < recordEntries.size(); i++) {
                RecordEntry currentEntry = recordEntries.get(i);
                if (currentEntry.getDateOfBirth().before(entryForOldestPerson.getDateOfBirth())) {
                    entryForOldestPerson = currentEntry;
                }
            }

            if (entryForOldestPerson != null) {
                entriesForOldestPerson.add(entryForOldestPerson);
            }
        }

        return entriesForOldestPerson;
    }

}
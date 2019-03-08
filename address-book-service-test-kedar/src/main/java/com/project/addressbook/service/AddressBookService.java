package com.project.addressbook.service;

import com.project.addressbook.criteria.Criteria;
import com.project.addressbook.model.RecordEntry;

import java.util.ArrayList;
import java.util.List;

public class AddressBookService {

    private List<RecordEntry> entries = new ArrayList<RecordEntry>();

    public int size() {
        return entries.size();
    }

    public void addEntry(RecordEntry recordEntry) {
        entries.add(recordEntry);
    }

    public List<RecordEntry> findBy(Criteria criteria) {
        return criteria.query(entries);
    }
}
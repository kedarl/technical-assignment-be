package com.project.addressbook.criteria;

import com.project.addressbook.enums.Gender;
import com.project.addressbook.model.RecordEntry;

import java.util.ArrayList;
import java.util.List;

public class GenderCriteria implements Criteria {
    private Gender gender;

    public GenderCriteria(Gender gender) {
        this.gender = gender;
    }

    @Override
    public List<RecordEntry> query(List<RecordEntry> recordEntries) {

        List<RecordEntry> entriesByGender = new ArrayList<RecordEntry>();
        for(RecordEntry recordEntry : recordEntries) {
            if (recordEntry.getGender() == gender) {
                entriesByGender.add(recordEntry);
            }
        }

        return entriesByGender;
    }
}
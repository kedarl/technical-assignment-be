package com.project.addressbook.criteria;

import com.project.addressbook.model.RecordEntry;

import java.util.List;

public interface Criteria {

    List<RecordEntry> query(List<RecordEntry> entries);

}
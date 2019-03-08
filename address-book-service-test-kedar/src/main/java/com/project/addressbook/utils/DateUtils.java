package com.project.addressbook.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Date;

public class DateUtils {

    public static int daysBetween(Date start, Date end) {
        return Days.daysBetween(new DateTime(start), new DateTime(end)).getDays();
    }

}
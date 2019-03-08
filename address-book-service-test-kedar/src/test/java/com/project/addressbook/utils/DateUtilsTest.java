package com.project.addressbook.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateUtilsTest {

    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");

    @Test
    public void daysBetweenReturnsActualNumberOfDaysBetween() throws Exception {
        // given
        Date date1 = simpleDateFormat.parse("01/02/70");
        Date date2 = simpleDateFormat.parse("05/02/70");

        // when
        int actualNumberOfDaysBetween = DateUtils.daysBetween(date1, date2);

        // then
        assertEquals(4, actualNumberOfDaysBetween);
    }
}

package com.project.appz;

import com.project.appz.utils.DateUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateUtilsTest {

    @Test
    void getCurrentDate_ShouldReturnCurrentDate() {
        LocalDate currentDate = DateUtils.getCurrentDate();

        assertNotNull(currentDate);
        LocalDate expectedDate = LocalDate.now();
        assertEquals(expectedDate, currentDate);
    }

    @Test
    void formatToString_ShouldReturnFormattedString() {
        LocalDate date = LocalDate.of(2023, 4, 10); // Example date
        String formattedDate = DateUtils.formatToString(date);
        assertEquals("2023-04-10", formattedDate);
    }
}

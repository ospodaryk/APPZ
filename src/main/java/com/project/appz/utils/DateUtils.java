package com.project.appz.utils;

import java.time.LocalDate;

public class DateUtils {
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static String formatToString(LocalDate date) {
        return date.toString();
    }
}

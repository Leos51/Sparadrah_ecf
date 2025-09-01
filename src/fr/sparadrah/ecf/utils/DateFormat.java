package fr.sparadrah.ecf.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    public static String formatFR(LocalDate date) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(myFormatObj);
    }

    public static LocalDate parseFR(String date) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, myFormatObj);
    }
}

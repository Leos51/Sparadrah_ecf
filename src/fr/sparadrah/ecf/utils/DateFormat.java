package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    public static String format(LocalDate date) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(myFormatObj);
    }
}

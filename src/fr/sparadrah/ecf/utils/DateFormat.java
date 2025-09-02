package fr.sparadrah.ecf.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormat {
    public static String formatDate(LocalDate date, String pattern) {
        if (date == null || pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("La date et le pattern ne peut pas etre null ou vide");
        }

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(pattern);
        return date.format(myFormatObj);
    }



    public static LocalDate parseDateFromString(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        }
        return null;
    }

}

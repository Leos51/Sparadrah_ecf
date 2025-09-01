package utils;

public class RegexPatterns {
    public static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
    public static final String NAME_REGEX = "^[A-Za-zÀ-ÖØ-öø-ÿ\\-\\s]+$";
    public static final String ISBN_REGEX = "^\\d{10}|\\d{13}$";
    public static final String BOOK_TITLE_REGEX = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9\\-\\s'’:,.!?]+$";
}

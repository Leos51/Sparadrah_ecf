package utils.validator;

import model.lists.books.Books;
import utils.RegexPatterns;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidName(String name){
        return name.matches(RegexPatterns.NAME_REGEX);
    }

    public static boolean isValidEmail(String email) {
        return email.matches(RegexPatterns.EMAIL_REGEX);
    }

    public static boolean isValidISBN(String isbn) {
        return isbn.matches(RegexPatterns.ISBN_REGEX);
    }

    public static boolean isValidPositiveInt(int quantity) {
        return quantity >= 0;
    }


    public static boolean isValidBookTitle(String title) {
        return title.matches(RegexPatterns.BOOK_TITLE_REGEX);
    }


}

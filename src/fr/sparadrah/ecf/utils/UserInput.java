package utils;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static String getStringValue(String msg){
        System.out.println(msg);
        String str = "";
        while (str.isBlank()) {
            str = sc.nextLine();
        }
        return str;
    }

    public static int getIntValue(String msg) {
        System.out.println(msg);
        String str = getStringValue(msg);
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.err.println("Erreur : entrée invalide. Veuillez saisir un entier.");
            return -1;
        }
    }

    public static int getParseIntValue(String msg) {
        System.out.println(msg);
        String str = getStringValue(msg);
        int num = Integer.parseInt(str);
        return num;

    }


//    public static double getDoubleValue(String msg){
//        System.out.println(msg);
//        double value = sc.nextDouble();
//        sc.nextLine();
//        return value;
//
//    }

//    public static long getLongValue(String msg) {
//        System.out.println(msg);
//        long value = sc.nextLong();
//        sc.nextLine();
//        return value;
//    }

    public static String capitalize(String word) {
        word = word.toLowerCase();
        return word.substring(0, 1).toUpperCase() + word.substring(1);

    }
}

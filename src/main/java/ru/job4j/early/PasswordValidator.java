package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper = true;
            }
            if (Character.isLowerCase(c)) {
                lower = true;
            }
            if (Character.isDigit(c)) {
                digit = true;
            }
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                special = true;
            }
            if (upper && lower && digit && special) {
                break;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!special) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (isPasswordContainsInvalidSubString(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean isPasswordContainsInvalidSubString(String password) {
        boolean result = false;
        String[] forbiddenWords = new String[] {"qwerty", "12345", "admin", "user", "password"};
        for (String forbiddenWord : forbiddenWords) {
            if (password.toUpperCase().contains(forbiddenWord.toUpperCase())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
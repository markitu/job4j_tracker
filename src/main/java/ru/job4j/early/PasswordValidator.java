package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!isStringContainsUpperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isStringContainsLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isStringContainsDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isStringContainsSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (isPasswordContainsValidSubString(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean isStringContainsUpperCase(String string) {
        boolean result = false;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isStringContainsLowerCase(String string) {
        boolean result = false;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLowerCase(string.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isStringContainsDigit(String string) {
        boolean result = false;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isStringContainsSpecialSymbol(String string) {
        boolean result = false;
        for (int i = 0; i < string.length(); i++) {
            int code = string.codePointAt(i);
            if (isSpecialSymbol(code)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isSpecialSymbol(int code) {
        return code >= 32 && code <= 47;
    }

    private static boolean isPasswordContainsValidSubString(String password) {
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
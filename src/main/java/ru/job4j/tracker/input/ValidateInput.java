package ru.job4j.tracker.input;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                if (value >= 0 && value <= 6) {
                    invalid = false;
                } else {
                    System.out.println("Пожалуйста, введите число от 0 до 6");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
        } while (invalid);
        return value;
    }
}
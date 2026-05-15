package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 0, 1, 5, 10, -5, -10);
        List<Integer> positive = numbers.stream()
                .filter(number -> number > 0)
                        .toList();
        positive.forEach(System.out::println);
    }
}